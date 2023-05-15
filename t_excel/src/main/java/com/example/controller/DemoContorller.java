package com.example.controller;

import com.example.entity.Apple;
import com.example.entity.Fruit;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: liaozhenyu
 * @date: 2022/09/22
 **/

@RestController
public class DemoContorller {

    @Resource(name = "userA")
    private User user1;

    @Resource(name = "userAA")
    private User user2;

    @Resource(name = "userB")
    private User user3;

    @Resource(name = "userBB")
    private User user4;

    @Value("${server.port}")
    private String port;

    @Autowired
    private Apple apple;

    @RequestMapping("port")
    public String port() {
        return port;
    }

    @RequestMapping("user")
    public String user() {
        return user1.getUsername() + "/" + user2.getUsername() + "/" + user3.getUsername() + "/" + user4.getUsername();
    }

    @RequestMapping("color")
    public String color() {
        Apple a = new Apple();
        return a.getColor() + "/" + apple.getColor();
    }

}
