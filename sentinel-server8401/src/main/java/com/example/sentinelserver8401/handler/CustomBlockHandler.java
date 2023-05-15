package com.example.sentinelserver8401.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author: liaozhenyu
 * @date: 2022/04/13
 **/
public class CustomBlockHandler {

    public static String handleException1(BlockException exception) {
        return "handleException1: 系统繁忙";
    }

    public static String handleException2(BlockException exception) {
        return "handleException2: 网络异常";
    }
}
