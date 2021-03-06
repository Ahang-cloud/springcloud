package com.ah.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class HystrixService {

    @HystrixCommand(fallbackMethod = "CircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled", value="true"),  // 是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"),  //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="10000"), // 时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="60"),  // 失败率达到多少后跳闸
            //整体意思：10秒内 10次请求且达到6次失败，就跳闸
    })
    public String circuitBreaker(Long id){
        if (id < 0){
            throw new RuntimeException("id不能小于0");
        }
        return "服务正常...";
    }

    public String CircuitBreaker_fallback(Long num){
        return "服务器故障，请稍后再试...";
    }
}
