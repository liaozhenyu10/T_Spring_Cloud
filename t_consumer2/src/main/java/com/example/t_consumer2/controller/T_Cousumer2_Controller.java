package com.example.t_consumer2.controller;

import com.example.t_consumer2.client.Provider1Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: liaozhenyu
 * @date: 2022/03/23
 **/

@RestController
@RequestMapping()
public class T_Cousumer2_Controller {

    @Autowired
    private Provider1Client provider1Client;

    @RequestMapping("greet")
    public String greet() {
        return "hello consumer2";
    }

    @RequestMapping("consume")
    public String consume() {
        return provider1Client.greek();
    }

    @RequestMapping("testHystrix")
    public String testHystrix(Integer id, HttpServletRequest request) {
        String username = request.getHeader("User-Name");
        System.out.println("请求头User-Name:" + username);
        System.out.println("id:" + id);
        return provider1Client.testHystrix(id);
    }


}
