package com.ah.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced//开启负载均衡,默认方式是轮询
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
