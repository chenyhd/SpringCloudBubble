package com.chenyh.provider.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GetWayConfig {
    @Bean
    @LoadBalanced //负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
        return new RoundRobinRule(); // 轮询方式实现负载均衡默认
        // return new RetryRule();
        // return new RandomRule(); //达到的目的，用我们重新选择的随机算法替代默认的轮询。
    }
}
