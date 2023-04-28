package com.example.trabbitmqprovider8801.controller;

import com.example.trabbitmqprovider8801.service.IMessageProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: liaozhenyu
 * @date: 2022/04/01
 **/
@RestController
public class MessageSendController {

    @Resource
    private IMessageProvider messageProvider;

    @RequestMapping("sendMessage")
    public String sendMessage() {
        messageProvider.send();
        return "success";
    }
}
