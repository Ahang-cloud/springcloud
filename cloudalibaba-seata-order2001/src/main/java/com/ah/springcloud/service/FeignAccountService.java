package com.ah.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-account-service")
public interface FeignAccountService {

    @PostMapping("/account/update")
    public void update(@RequestParam("money") Double money,@RequestParam("userId") Long userId);
}
