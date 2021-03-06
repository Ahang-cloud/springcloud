package com.ah.springcloud.service;

import com.ah.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-provider-payment")
public interface FeignService {
    @GetMapping(value = "/payment/findById/{id}")
//@PathVariable 将URL中占位符参数{xxx}绑定到类的方法形参中@PathVariable(“xxx“) url:findById/3
//@RequestParam("id") 表示请求路径中必须含有该参数，这种方式的 url:findById?id=2
    public CommonResult findById(@PathVariable("id") Long id);
}
