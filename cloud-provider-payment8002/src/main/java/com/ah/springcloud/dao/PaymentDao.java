package com.ah.springcloud.dao;

import com.ah.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    int add(Payment payment);
    Payment findById(@Param("id") Long id);
}
