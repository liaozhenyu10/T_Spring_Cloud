package com.example.log4j29092.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liaozhenyu
 * @date: 2022/09/30
 **/

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @Value("test")
    private String test;

    @RequestMapping("log")
    public String log() {


        for (int i = 0; i <100 ; i++) {
            log.info("info......{}", Thread.currentThread().getName());
            log.warn("warn......{}", Thread.currentThread().getName());
            log.error("error......{}", Thread.currentThread().getName());
        }


        return test;
    }
}
