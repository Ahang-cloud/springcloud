package com.ah.springcloud.controller;

import com.ah.springcloud.entities.CommonResult;
import com.ah.springcloud.entities.Payment;
import com.ah.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//@RestController 相当于 @ResponseBody 和 @Controller 结合
@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/findById/{id}")
//@PathVariable 将URL中占位符参数{xxx}绑定到类的方法形参中@PathVariable(“xxx“) url:findById/3
//@RequestParam("id") 表示请求路径中必须含有该参数，这种方式的 url:findById?id=2
    public CommonResult findById(@PathVariable("id") Long id){
        Payment payment = paymentService.findById(id);
        log.info("***查询结果：" + payment);
        if (payment != null){
            return new CommonResult(200,port+":查询成功",payment);
        }else {
            return new CommonResult<Payment>(200,"未查询到");
        }
    }

    @PostMapping(value = "/add")
    // @RequestBody 在使用时请求数据必须有请求体，否则无法请求，参数的获取在请求体中
    //如果不添加前端请求以请求体json方式传递的数据无法封装
    public CommonResult add(@RequestBody Payment payment){
        int num = paymentService.add(payment);
        log.info("插入数据的ID:\t" + payment.getId());
        log.info("插入结果：" + num);
        if (num>0){
            return new CommonResult(200,port+":添加成功",payment);
        }else {
            return new CommonResult(444,"添加失败");
        }
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element:services) {
            log.info("*****service:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment");
        for (ServiceInstance instance:instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost()
                    + "\t" + instance.getPort() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return port;
    }

    @GetMapping(value = "/timeout")
    public String Timeout(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "超时任务运行成功";
    }

}
