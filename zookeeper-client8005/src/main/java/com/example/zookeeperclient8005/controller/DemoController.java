package com.example.zookeeperclient8005.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: liaozhenyu
 * @date: 2022/04/05
 **/

@RestController
public class DemoController {

    private static final String URL = "http://zookeeperClient8004";

    @Resource
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String port;

    @RequestMapping("port")
    public String port() {
        return port;
    }

    @RequestMapping("8004")
    public String get() {
        return restTemplate.getForObject(URL + "/port", String.class);
    }
}
