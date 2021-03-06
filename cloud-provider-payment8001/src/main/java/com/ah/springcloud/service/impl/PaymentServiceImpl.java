package com.ah.springcloud.service.impl;

import com.ah.springcloud.dao.PaymentDao;
import com.ah.springcloud.entities.Payment;
import com.ah.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;


    @Override
    public Payment findById(Long id) {
        return paymentDao.findById(id);
    }

    @Override
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }
}
