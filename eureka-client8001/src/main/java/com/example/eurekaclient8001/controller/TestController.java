package com.example.eurekaclient8001.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: liaozhenyu
 * @date: 2022/04/02
 **/

@RestController
public class TestController {

    public static final String PROVIDER_URL = "http://EUREKACLIENTCLUSTER";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("consume")
    public String consumer() {
        return restTemplate.getForObject(PROVIDER_URL + "/port", String.class);
    }
}
