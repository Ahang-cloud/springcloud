package com.ah.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.ah.springcloud.dao"})
public class MybatisConfig {
}
