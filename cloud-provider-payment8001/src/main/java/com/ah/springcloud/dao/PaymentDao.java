package com.ah.springcloud.dao;

import com.ah.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface PaymentDao {
    //@Param 给参数命名,参数命名后就能根据名字得到参数值,正确的将参数传入sql语句中，相当于给参数起别名
    public Payment findById(@Param("id") Long id);
    public int add(Payment payment);
}
