package com.ah.springcloud.controller;

import com.ah.springcloud.LB.LoadBalancer;
import com.ah.springcloud.entities.CommonResult;
import com.ah.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
    //private final static String PAYMENT_URL = "http://localhost:8001";
    //集群需要改成服务注册名
    private final static String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/add")
    public CommonResult add(@RequestBody Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,CommonResult.class);
    }

    @GetMapping("/payment/findById/{id}")
    public CommonResult findById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/findById/"+id,CommonResult.class,id);
    }

    @GetMapping("/payment/lb")
    public String PaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

}
