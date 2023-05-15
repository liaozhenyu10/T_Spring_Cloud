package com.example.springdatajpa9006.controller;

import com.alibaba.fastjson.JSON;
import com.example.springdatajpa9006.entity.UbOpenBank;
import com.example.springdatajpa9006.repository.UbOpenBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author: liaozhenyu
 * @date: 2022/09/23
 **/
@RestController

public class UbOpenBankController {

    @Autowired
    private UbOpenBankRepository ubOpenBankRepository;

    @RequestMapping("test")
    public String test() {
        Optional<UbOpenBank> byId = ubOpenBankRepository.findById("165c83c90694b692df17c6f45c383fbe");
        UbOpenBank ubOpenBank = byId.get();
        return JSON.toJSONString(ubOpenBank);
    }
}
