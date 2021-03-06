package com.ah.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/{id}")
    public String message(@PathVariable("id") Long id){
        return "欢迎使用nacos："+serverPort+"---id="+id;
    }
}
