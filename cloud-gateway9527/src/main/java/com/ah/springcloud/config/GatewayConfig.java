package com.ah.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 编码方式进行 Gateway 路由配置
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator setRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();

        //相当于进行了地址转发
        //访问 localhost:9527/baidu 就会跳转到 https://www.baidu.com
        RouteLocator routeLocator = routes.route("path_baidu",
                //相当于配置文件中的Path，需要和底下的后面对应才能匹配，点开网页其他的也需要加入配置
                x -> x.path("/guonei")
                        .uri("https://news.baidu.com/guonei")).build();
        return routeLocator;
    }
}
