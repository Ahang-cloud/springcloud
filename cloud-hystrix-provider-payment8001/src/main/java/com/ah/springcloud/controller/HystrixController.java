package com.ah.springcloud.controller;

import com.ah.springcloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class HystrixController {

    @Resource
    private HystrixService hystrixService;

    @GetMapping("/payment/circuitBreaker/{id}")
    public String circuitBreaker(@PathVariable("id") Long id){
        return hystrixService.circuitBreaker(id);
    }
}
