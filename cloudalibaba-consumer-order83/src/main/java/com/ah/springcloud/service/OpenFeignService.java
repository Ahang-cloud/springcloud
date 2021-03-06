package com.ah.springcloud.service;

import com.ah.springcloud.service.impl.Payment9001ServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-provider",fallback = Payment9001ServiceImpl.class)
public interface OpenFeignService {

    @GetMapping("/payment/{id}")
    public String message(@PathVariable("id") Long id);
}
