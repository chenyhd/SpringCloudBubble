package com.chenyh.configserverdb.config;

import com.chenyh.configserverdb.mapper.TvuConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.EnvironmentRepository;
import org.springframework.core.Ordered;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@ConfigurationProperties("spring.cloud.config.server.jdbc")
public class TvuJdbcEnvironmentRepository implements EnvironmentRepository, Ordered {

    private static final String DEFAULT_SQL = "SELECT KEY, VALUE from PROPERTIES where APPLICATION=? and PROFILE=? and LABEL=?";
    private int order = Ordered.LOWEST_PRECEDENCE - 10;
    private TvuConfigMapper tvuConfigMapper;
    private String sql = DEFAULT_SQL;

    public TvuJdbcEnvironmentRepository(TvuConfigMapper tvuConfigMapper) {
        this.tvuConfigMapper = tvuConfigMapper;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return this.sql;
    }

    @Override
    public Environment findOne(String application, String profile, String label) {
        String config = application;
        if (StringUtils.isEmpty(label)) {
            label = "master";
        }
        if (StringUtils.isEmpty(profile)) {
            profile = "default";
        }
        if (!profile.startsWith("default")) {
            profile = "default," + profile;
        }
        String[] profiles = StringUtils.commaDelimitedListToStringArray(profile);
        Environment environment = new Environment(application, profiles, label, null,
                null);
//        if (!config.startsWith("application")) {
//            config = "application," + config;
//        }
        List<String> applications = new ArrayList<String>(new LinkedHashSet<>(
                Arrays.asList(StringUtils.commaDelimitedListToStringArray(config))));
        List<String> envs = new ArrayList<String>(new LinkedHashSet<>(Arrays.asList(profiles)));
        Collections.reverse(applications);
        Collections.reverse(envs);
        for (String app : applications) {
            for (String env : envs) {
                List<Map<String, String>> next = tvuConfigMapper.findOne(application, env, label);
                Map<String, String> stringStringMap = next.stream().collect(Collectors.toMap(x -> x.get("KEY"), y -> y.get("VALUE")));
                if (!stringStringMap.isEmpty()) {
                    environment.add(new PropertySource(app + "-" + env, stringStringMap));
                }
            }
        }
        return environment;
    }

    @Override
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

}