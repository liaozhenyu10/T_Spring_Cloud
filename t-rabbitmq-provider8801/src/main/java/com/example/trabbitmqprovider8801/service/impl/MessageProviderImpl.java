package com.example.trabbitmqprovider8801.service.impl;

import com.example.trabbitmqprovider8801.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author: liaozhenyu
 * @date: 2022/04/01
 **/
@EnableBinding(Source.class)
//定义消息推送的管道，source 源 输出 生产者 enableBinding指信道channel与exchange绑定到一起，对应配置中的spring.cloud.stream.bindings.output...
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;  //消息发送通道

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("******uuid: " + uuid);
        return null;
    }
}
