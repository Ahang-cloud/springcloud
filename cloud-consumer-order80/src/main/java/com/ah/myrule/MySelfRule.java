package com.ah.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//自定义负载均衡配置类
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();    ////负载均衡规则定义为随机
    }
}
