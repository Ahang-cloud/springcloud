package com.ah.springcloud.controller;

import com.ah.springcloud.domain.Order;
import com.ah.springcloud.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class SeataOrderController {
    @Resource
    private OrderServiceImpl orderService;

    @PostMapping("/order/buy")
    public void buy(Order order){
        orderService.buy(order);
    }
}
