package com.example.t_configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liaozhenyu
 * @date: 2022/03/28
 **/

@RestController
@RefreshScope
public class DemoController {

    @Value("${name}")
    private String name;

    @Value("${color}")
    private String color;

    @RequestMapping("demo")
    public String demo() {
        return name;
    }

    @RequestMapping("color")
    public String color() {
        return color;
    }
}
