package com.ah.springcloud.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

// 配置全局过滤器
@Component
public class GatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("---come in MyGlobalFilter : "+ new Date());
        //获取Get请求的参数key是 username的值
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        System.out.println(username);
        if (username == null){
            System.out.println("请先登录...");
            //设置响应请求状态码
            exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
            //完成请求调用
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    // 返回值对应加载顺序，越大越排在后面
    @Override
    public int getOrder() {
        return 0;
    }
}
