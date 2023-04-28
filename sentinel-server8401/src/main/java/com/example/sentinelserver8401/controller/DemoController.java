package com.example.sentinelserver8401.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.sentinelserver8401.handler.CustomBlockHandler;
import com.example.sentinelserver8401.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author: liaozhenyu
 * @date: 2022/04/11
 **/

@RestController
public class DemoController {

    private static final String URL = "http://nacosClientCluster";

    @Value("${server.port}")
    private String port;

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private DemoService demoService;

    @RequestMapping("port")
    public String port() throws InterruptedException {
        System.out.println(LocalDateTime.now());
        return port;
    }

    @RequestMapping("testA")
    public String testA() {
        return demoService.common("testA");
    }

    @RequestMapping("testB")
    public String testB() {
        return demoService.common("testB");
    }

    @GetMapping("testC")
    public String testC(@RequestParam("time") Integer time) throws InterruptedException {
        Thread.sleep(time);
        System.out.println("te stC: " + Thread.currentThread().getName());
        return "testC";
    }

    @GetMapping("testD")
    public String testD(@RequestParam(value = "e", required = false) String e) throws InterruptedException {

        if (e != null) {
            throw new RuntimeException("异常");
        }
        return "testD";
    }

    @GetMapping("testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "handler_hotKey")
    public String testHotKey(@RequestParam(value = "hot1", required = false) String hot1,
                             @RequestParam(value = "hot2", required = false) String hot2,
                             @RequestParam(value = "hot3", required = false) String hot3) {
        return "hotKey";
    }

    @GetMapping("byResource")
    @SentinelResource(value = "byResource", blockHandlerClass = CustomBlockHandler.class, blockHandler = "handleException2")
    public String byResource() {
        return "byResource";
    }

    public String handler_hotKey(String hot1, String hot2, String hot3, BlockException exception) {
        return "系统繁忙请稍后再试";
    }

    @RequestMapping("demo")
    public String demo() {
        String res = restTemplate.getForObject(URL + "/port", String.class);
        System.out.println("**********port: " + res);
        return res;
    }
}
