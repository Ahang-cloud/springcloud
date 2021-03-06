package com.ah.springcloud.service;

import com.ah.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int add(Payment payment);
    Payment findById(@Param("id") Long id);
}
