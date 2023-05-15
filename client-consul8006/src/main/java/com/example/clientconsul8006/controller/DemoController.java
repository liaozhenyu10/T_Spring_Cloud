package com.example.clientconsul8006.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liaozhenyu
 * @date: 2022/04/06
 **/

@RestController
public class DemoController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("port")
    public String port() {
        return port;
    }
}
