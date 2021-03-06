package com.ah.springcloud.controller;

import com.ah.springcloud.entities.CommonResult;
import com.ah.springcloud.service.FeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback="GlobalHandler", commandProperties = {
//        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//})
public class FeignOrderController {

    @Resource
    private FeignService feignService;

    @GetMapping(value = "consumer/payment/findById/{id}")
    public CommonResult findById(@PathVariable("id") Long id){
        return feignService.findById(id);
    }

//    @HystrixCommand(fallbackMethod = "TimeOutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
//    @HystrixCommand
    @GetMapping(value = "/consumer/payment/timeout")
    public String Timeout(){
        return feignService.Timeout();
    }

    public String TimeOutHandler(){
        return "服务器请求超时，请稍后再试...";
    }

    public String GlobalHandler(){
        return "服务器繁忙，请稍后再试...";
    }
}
