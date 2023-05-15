package com.example.nacosconfig8013.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liaozhenyu
 * @date: 2022/04/07
 **/
@RestController
@RefreshScope
public class DemoController {
//    @Value("${config.info}")
//    private String configInfo;

    @Value("${shared.config}")
    private String sharedConfig;

    @RequestMapping("sharedConfig")
    public String sharedConfig() {
        return sharedConfig;
    }

//    @RequestMapping("configInfo")
//    public String configInfo() {
//        return configInfo;
//    }
}
