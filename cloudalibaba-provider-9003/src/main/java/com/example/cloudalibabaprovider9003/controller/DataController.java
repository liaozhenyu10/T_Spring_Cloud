package com.example.cloudalibabaprovider9003.controller;

import com.example.cloudalibabacommons.entity.JsonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author: liaozhenyu
 * @date: 2022/04/13
 **/

@RestController
public class DataController {

    @Value("${server.port}")
    private String serverPort;

    private static HashMap<Long, String> map = new HashMap<>();

    static {
        map.put(1L, "鼠标");
        map.put(2L, "耳机");
        map.put(3L, "键盘");
    }

    @GetMapping("info/{id}")
    public JsonResult<String> get(@PathVariable("id") Long id) {
        JsonResult<String> result = new JsonResult<>(200, map.get(id));
        return result;
    }

}
