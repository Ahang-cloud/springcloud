package com.ah.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;
    private String ddd;

    @GetMapping("/payment/consul")
    public String paymentInfo(){
        return "springcloud with consul: "+ serverPort +"\t" + UUID.randomUUID().toString();
    }
}
