package com.example.clientnacos8012.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author: liaozhenyu
 * @date: 2022/04/06
 **/
@RestController
public class DemoController {

    private static final String URL = "http://nacosClientCluster";

    @Value("${server.port}")
    private String port;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("port")
    public String port() {
        return port;
    }

    @RequestMapping("demo")
    public String demo() {
        String res = restTemplate.getForObject(URL + "/port", String.class);
        System.out.println("*****port: " + res);
        return res;
    }
}
