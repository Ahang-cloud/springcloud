package com.ah.springcloud.service;

import com.ah.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public Payment findById(@Param("id") Long id);
    public int add(Payment payment);
}
