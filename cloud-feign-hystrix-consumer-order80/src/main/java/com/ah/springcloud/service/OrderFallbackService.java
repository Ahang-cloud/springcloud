package com.ah.springcloud.service;

import com.ah.springcloud.entities.CommonResult;
import org.springframework.stereotype.Component;

@Component
public class OrderFallbackService implements FeignService{
    @Override
    public CommonResult findById(Long id) {
        return null;
    }

    @Override
    public String Timeout() {
        return "超时等待...";
    }
}
