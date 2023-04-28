package com.example.t_provider1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TProvider1Application {

    public static void main(String[] args) {
        SpringApplication.run(TProvider1Application.class, args);
    }

}
