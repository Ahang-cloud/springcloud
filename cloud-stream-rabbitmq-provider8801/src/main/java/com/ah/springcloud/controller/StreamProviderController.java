package com.ah.springcloud.controller;

import com.ah.springcloud.service.StreamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StreamProviderController {

    @Resource
    private StreamService streamService;

    @GetMapping("/send")
    public String sendMessage(){
       return streamService.sendMessage();
    }
}
