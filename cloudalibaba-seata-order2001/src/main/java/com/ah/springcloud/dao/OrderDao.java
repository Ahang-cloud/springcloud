package com.ah.springcloud.dao;

import com.ah.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {

    void createOrder(Order order);
    void updateStatus(Long userId);
}
