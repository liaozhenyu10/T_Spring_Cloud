package com.example.t_configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liaozhenyu
 * @date: 2022/03/28
 **/

@RestController
public class TestController {
    @Value("${name}")
    private String name;

    @Value("${color}")
    private String color;

    @RequestMapping("test")
    public String test() {
        return color;
    }
}
