package com.example.t_configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TConfigclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TConfigclientApplication.class, args);
    }

}
