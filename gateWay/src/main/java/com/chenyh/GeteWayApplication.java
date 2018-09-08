package com.chenyh;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy //EnableZuulProxy包含@EnableDiscoveryClient
public class GeteWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GeteWayApplication.class, args);
    }
}
