package com.chenyh.configserverdb.config;

import ch.qos.logback.classic.Logger;
import com.chenyh.configserverdb.mapper.TvuConfigMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ConfigServerConfig {

    @Value("${spring.profiles.active}")
    private String profile;

    @Bean
    @Profile("tvu")
    public TvuJdbcEnvironmentRepository TvuJdbcEnvironmentRepository(TvuConfigMapper tvuConfigMapper) {
        return new TvuJdbcEnvironmentRepository(tvuConfigMapper);
    }

    @Bean
    @Profile("jdbc")
    @ConditionalOnClass(JdbcTemplate.class)
    public Object object(){
        System.out.println(profile);
        return  null;
    }

    @Bean
    @Profile("jdbc")
    public Object object1(){
        System.out.println(profile);
        return  null;
    }

}
