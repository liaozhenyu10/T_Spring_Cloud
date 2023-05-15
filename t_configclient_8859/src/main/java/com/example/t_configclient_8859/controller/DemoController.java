package com.example.t_configclient_8859.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liaozhenyu
 * @date: 2022/03/31
 **/
@RestController
@RefreshScope
public class DemoController {

    @Value("${color}")
    private String color;

    @RequestMapping("demo")
    public String demo() {
        return color;
    }
}
