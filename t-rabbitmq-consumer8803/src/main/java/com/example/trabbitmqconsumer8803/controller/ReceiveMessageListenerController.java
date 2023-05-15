package com.example.trabbitmqconsumer8803.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author: liaozhenyu
 * @date: 2022/04/01
 **/
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT) //监听队列，用于消费者的队列消息接收
    public void input(Message<String> message) {
        System.out.println("消费者" + port + "收到消息：" + message.getPayload());
    }
}
