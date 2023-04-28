package com.example.uploadfile8801.oa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liaozhenyu
 * @date: 2022/04/25
 **/

@RestController
public class OAController {

    @RequestMapping("Interfaces/addVendoutTypes")
    public Integer oATest(String id, String name) {
        System.out.println("1111111111");

        return 1;
    }
}
