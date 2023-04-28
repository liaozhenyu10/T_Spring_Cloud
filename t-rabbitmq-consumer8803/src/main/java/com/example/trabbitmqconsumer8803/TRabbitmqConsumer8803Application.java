package com.example.trabbitmqconsumer8803;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TRabbitmqConsumer8803Application {

    public static void main(String[] args) {
        SpringApplication.run(TRabbitmqConsumer8803Application.class, args);
    }

}
