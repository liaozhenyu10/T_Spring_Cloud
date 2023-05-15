package com.example.eurekaclient8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClient8001Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient8001Application.class, args);
    }

    @Bean
    @LoadBalanced   //赋予restTemplate负载均衡的能力
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
