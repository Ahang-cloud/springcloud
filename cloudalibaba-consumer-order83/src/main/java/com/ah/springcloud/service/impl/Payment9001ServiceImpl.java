package com.ah.springcloud.service.impl;

import com.ah.springcloud.service.OpenFeignService;
import org.springframework.stereotype.Component;

@Component
public class Payment9001ServiceImpl implements OpenFeignService {
    @Override
    public String message(Long id) {
        return "OpenFeign 的降级方法调用了...";
    }
}
