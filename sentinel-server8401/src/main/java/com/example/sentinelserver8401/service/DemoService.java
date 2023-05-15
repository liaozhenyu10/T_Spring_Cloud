package com.example.sentinelserver8401.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @author: liaozhenyu
 * @date: 2022/04/12
 **/
@Service
public class DemoService {

    @SentinelResource("common")
    public String common(String arg) {
        return "common:" + arg;
    }
}
