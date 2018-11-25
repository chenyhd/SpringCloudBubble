package com.chenyh.configserverdb;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
@MapperScan("com.chenyh.configserverdb.mapper")
public class ConfigServerDBApplication {


    public static void main(String[] args) {
        SpringApplication.run(ConfigServerDBApplication.class, args);
    }
}
