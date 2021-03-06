package com.ah.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients   //关键注解
public class FeignOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderMain80.class, args);
    }
}
