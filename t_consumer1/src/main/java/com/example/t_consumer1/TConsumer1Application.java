package com.example.t_consumer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TConsumer1Application {

    public static void main(String[] args) {
        SpringApplication.run(TConsumer1Application.class, args);
    }

}
