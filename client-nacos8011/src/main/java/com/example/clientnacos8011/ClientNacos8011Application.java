package com.example.clientnacos8011;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientNacos8011Application {

    public static void main(String[] args) {
        SpringApplication.run(ClientNacos8011Application.class, args);
    }

}
