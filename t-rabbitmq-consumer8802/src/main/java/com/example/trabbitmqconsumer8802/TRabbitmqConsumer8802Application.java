package com.example.trabbitmqconsumer8802;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TRabbitmqConsumer8802Application {

    public static void main(String[] args) {
        SpringApplication.run(TRabbitmqConsumer8802Application.class, args);
    }

}
