package com.ah.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface FeignStorageService {

    @PostMapping("/storage/update")
    public void updateResidue(@RequestParam("num") Integer num,@RequestParam("userId") Long userId);
}
