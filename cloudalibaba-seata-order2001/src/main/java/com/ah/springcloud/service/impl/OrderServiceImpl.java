package com.ah.springcloud.service.impl;

import com.ah.springcloud.dao.OrderDao;
import com.ah.springcloud.domain.Order;
import com.ah.springcloud.service.FeignAccountService;
import com.ah.springcloud.service.FeignStorageService;
import com.ah.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {


    @Resource
    private FeignStorageService feignStorageService;
    @Resource
    private FeignAccountService accountService;
    @Resource
    private OrderDao orderDao;

    @Override
    @GlobalTransactional(name = "ah-buy-order",rollbackFor = Exception.class)
    public void buy(Order order) {
        log.info("------->开始创建订单");
        orderDao.createOrder(order);
        log.info("------->订单创建完成");
        log.info("------->开始扣减库存");
        feignStorageService.updateResidue(order.getCount(),order.getUserId());
        log.info("------->库存扣减完成");
        log.info("------->开始扣减账户");
        accountService.update(order.getMoney(),order.getUserId());
        log.info("------->账户扣减完成");
        log.info("------->开始更新订单状态");
        orderDao.updateStatus(order.getUserId());
        log.info("------->订单完成");
    }
}
