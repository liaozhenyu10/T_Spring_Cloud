package com.example.uploadfile8801.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liaozhenyu
 * @date: 2022/04/14
 **/

@RestController
public class DemoController {

    @Value(("${server.port}"))
    private String port;

    @RequestMapping("port")
    public BResponse<String> port() {

        BResponse<String> stringBResponse = new BResponse<>();

        stringBResponse.setCode(200);
        stringBResponse.setMsg("ssss");

        return stringBResponse;
    }
}
