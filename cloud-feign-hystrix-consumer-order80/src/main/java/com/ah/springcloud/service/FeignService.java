package com.ah.springcloud.service;

import com.ah.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-provider-payment",fallback = OrderFallbackService.class)
public interface FeignService {
    @GetMapping(value = "/payment/findById/{id}")
    public CommonResult findById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/timeout")
    public String Timeout();
}
