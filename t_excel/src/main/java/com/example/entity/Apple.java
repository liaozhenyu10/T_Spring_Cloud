package com.example.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: liaozhenyu
 * @date: 2022/09/23
 **/


@Data
//@ConfigurationProperties(prefix = "config")
public class Apple implements Fruit {

    private String color;

}
