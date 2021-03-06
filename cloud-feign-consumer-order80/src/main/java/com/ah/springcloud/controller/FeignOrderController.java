package com.ah.springcloud.controller;

import com.ah.springcloud.entities.CommonResult;
import com.ah.springcloud.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FeignOrderController {
    @Autowired
    private FeignService feignService;

    @GetMapping(value = "consumer/feign/payment/findById/{id}")
    public CommonResult findById(@PathVariable("id") Long id){
        return feignService.findById(id);
    }
}
