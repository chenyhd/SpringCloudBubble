package com.chenyh.provider.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// springboot 在启动时默认扫描主类下的包，
// user-consumer主类在com.chenyh,consumer包下
//
@ComponentScan("com.chenyh")
public class Config {

    public Config() {
        System.out.println("Config 实例化");
    }


//    @Bean
//    SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory, ExecutorType.BATCH);
//        return sessionTemplate;
//    }

}
