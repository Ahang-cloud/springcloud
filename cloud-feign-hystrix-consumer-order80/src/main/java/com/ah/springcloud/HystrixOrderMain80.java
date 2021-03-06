package com.ah.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients   //关键注解
@EnableCircuitBreaker       //Hystrix服务降级注解
public class HystrixOrderMain80 {
    public static void main(String[] args){
        SpringApplication.run(HystrixOrderMain80.class, args);
    }
}
