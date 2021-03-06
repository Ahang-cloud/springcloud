package com.ah.springcloud;

import com.ah.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
            SpringApplication.run(OrderMain80.class, args);
    }
}