package com.example.clientsleuth8008.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: liaozhenyu
 * @date: 2022/04/06
 **/
@RestController
public class DemoController {

    private static final String URL1 = "http://client-consul8006";

    private static final String URL2 = "http://client-consul8007";

    @Value("${server.port}")
    private String port;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("port")
    public String port() {
        return port;
    }

    @RequestMapping("demo")
    public String demo() {
        String port1 = restTemplate.getForObject(URL1 + "/port", String.class);
        String port2 = restTemplate.getForObject(URL2 + "/port", String.class);
        System.out.println("********port1: " + port1 + " prot2: " + port2);
        return port1 + "/" + port2;
    }
}
