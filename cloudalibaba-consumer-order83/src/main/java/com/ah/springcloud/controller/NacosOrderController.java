package com.ah.springcloud.controller;

import com.ah.springcloud.service.OpenFeignService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NacosOrderController {

    @Value("${server-url.nacos-user-service}")
    private String serverUrl;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/{id}")
    public String message(@PathVariable("id") Long id){
        return restTemplate.getForObject(serverUrl+"/payment/"+id,String.class);
    }

    //openFeign 方式
    @Resource
    private OpenFeignService openFeignService;

    @GetMapping("/consumer/get/{id}")
    public String get(@PathVariable("id") Long id){
        return openFeignService.message(id);
    }
}
