package com.example.t_configclient_8859;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TConfigclient8859Application {

    public static void main(String[] args) {
        SpringApplication.run(TConfigclient8859Application.class, args);
    }

}
