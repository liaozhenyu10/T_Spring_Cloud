package com.example.demoapi8090.controller;

import com.alibaba.fastjson.JSON;
import com.example.demoapi8090.form.TestForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liaozhenyu
 * @date: 2022/11/11
 **/

@RequestMapping("test")
@RestController
@Slf4j
@CrossOrigin(originPatterns = "*", allowCredentials = "true", maxAge = 3600)
public class TestController {

    @PostMapping(params="method=a")
    public String test(TestForm form) {
        log.info("param:{}", JSON.toJSONString(form));
        return "test api";
    }

    @PostMapping(params="method=b")
    public String testt(TestForm form) {
        log.info("param:{}", JSON.toJSONString(form));
        return "testt";
    }

    @RequestMapping("2")
    public String test2(@RequestParam(required = false) Map<String, Object> map, HttpServletRequest req) {
        String contentType = req.getContentType();
        log.info(contentType);
        log.info("test2, param:{}", JSON.toJSONString(map));
        return "test2 api";
    }

    @RequestMapping("3")
    public List<Map<String, String>> test3() {
        log.info("test3 api.........");

        Map<String, String> map1 = new HashMap<>();
        map1.put("text", "张三");
        map1.put("value","001");

        Map<String, String> map2 = new HashMap<>();
        map2.put("text", "李四");
        map2.put("value","002");

        ArrayList<Map<String, String>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);

        return list;
    }

    @GetMapping("4")
    public List<Map<String, String>> test4() {
        log.info("test4 api.........");

        Map<String, String> map1 = new HashMap<>();
        map1.put("text", "张4");
        map1.put("value","001");

        Map<String, String> map2 = new HashMap<>();
        map2.put("text", "李4");
        map2.put("value","002");

        ArrayList<Map<String, String>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);

        return list;
    }

    @PostMapping("5")
    public List<Map<String, String>> test5() {
        log.info("test5 api.........");

        Map<String, String> map1 = new HashMap<>();
        map1.put("text", "张5");
        map1.put("value","001");

        Map<String, String> map2 = new HashMap<>();
        map2.put("text", "李5");
        map2.put("value","002");

        ArrayList<Map<String, String>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);

        return list;
    }


    public static void main(String[] args) {
        System.out.println(TestController.class.equals(TestController.class));
    }

}
