package com.example.t_provider1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liaozhenyu
 * @date: 2022/03/23
 **/

@RestController
@RequestMapping()
public class T_Provider1_Controller {

    @GetMapping("greet")
    public String greet() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("2222222222222222");
        return "hello provider1_2";
    }

    @RequestMapping("testHystrix")
    public String testHystrix(Integer id) throws InterruptedException {
        System.out.println("id:" + id);
        Thread.sleep(2000);
        if (id < 0) {
            throw new RuntimeException();
        } else {
            return "调用成功";
        }
    }

}
