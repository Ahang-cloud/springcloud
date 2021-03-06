package com.ah.springcloud.service.impl;

import com.ah.springcloud.service.StreamService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
public class StreamServiceImpl implements StreamService {

    @Resource
    private MessageChannel output;

    @Override
    public String sendMessage() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("------消息生产方serialId:"+serial);
        return null;
    }
}
