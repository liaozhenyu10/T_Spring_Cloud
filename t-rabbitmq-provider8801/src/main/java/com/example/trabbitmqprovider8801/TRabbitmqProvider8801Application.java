package com.example.trabbitmqprovider8801;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TRabbitmqProvider8801Application {

    public static void main(String[] args) {
        SpringApplication.run(TRabbitmqProvider8801Application.class, args);
    }

}
