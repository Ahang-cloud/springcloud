package com.ah.springcloud.controller;

import com.ah.springcloud.entities.CommonResult;
import com.ah.springcloud.entities.Payment;
import com.ah.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;

    @GetMapping("/findById/{id}")
    public CommonResult findById(@PathVariable("id") Long id){
        Payment payment = paymentService.findById(id);
        log.info("***查询结果是***"+payment);
        if (payment != null){
            return new CommonResult(200,port+":查询成功",payment);
        }else {
            return new CommonResult(444,"未查询到");
        }
    }

    @PostMapping("/findById/{id}")
    public CommonResult add(@RequestBody Payment payment){
        int num = paymentService.add(payment);
        log.info("插入数据的ID:\t" + payment.getId());
        log.info("插入结果：" + num);
        if (num > 0){
            return new CommonResult(200,port+":添加成功",payment);
        }else {
            return new CommonResult(444,"添加失败");
        }
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return port;
    }
}
