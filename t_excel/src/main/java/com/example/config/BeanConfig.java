package com.example.config;

import com.example.entity.Apple;
import com.example.entity.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author: liaozhenyu
 * @date: 2022/09/22
 **/

@Configuration
public class BeanConfig {

    @Bean(name = {"userA", "userAA"})
    public User user1() {
        User user = new User();
        user.setUid(1);
        user.setUsername("A");
        return user;
    }

    @Bean(name = {"userBB", "userB"})
    @Primary
    public User user2() {
        User user = new User();
        user.setUid(1);
        user.setUsername("B");
        return user;
    }

    @Bean
    @ConfigurationProperties(prefix = "config")
    public Apple apple() {
        return new Apple();
    }

}
