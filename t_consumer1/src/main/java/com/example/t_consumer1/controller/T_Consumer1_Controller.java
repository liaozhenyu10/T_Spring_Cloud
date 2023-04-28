package com.example.t_consumer1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liaozhenyu
 * @date: 2022/03/23
 **/

@RestController
@RequestMapping()
public class T_Consumer1_Controller {

    @RequestMapping("greet")
    public String greet() {
        return "hello consumer1";
    }
}
