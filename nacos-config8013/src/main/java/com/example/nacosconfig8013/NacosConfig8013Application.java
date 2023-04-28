package com.example.nacosconfig8013;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfig8013Application {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfig8013Application.class, args);
    }

}
