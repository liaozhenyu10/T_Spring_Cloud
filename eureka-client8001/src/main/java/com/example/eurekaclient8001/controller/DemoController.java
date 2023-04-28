package com.example.eurekaclient8001.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: liaozhenyu
 * @date: 2022/04/02
 **/

@RestController
public class DemoController {

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("port")
    public String demo() {
        System.out.println("*****Port: " + port);
        return port;
    }

    @RequestMapping("discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);
        List<ServiceInstance> eurekaclientcluster = discoveryClient.getInstances("eurekaclientcluster");
        eurekaclientcluster.forEach(e -> {
            System.out.println(e.getServiceId() + "\t" + e.getHost() + "\t" + e.getPort() + "\t" + e.getUri());
        });
        return discoveryClient;
    }
}
