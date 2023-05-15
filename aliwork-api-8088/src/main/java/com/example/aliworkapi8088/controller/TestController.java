package com.example.aliworkapi8088.controller;

import com.example.aliworkapi8088.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liaozhenyu
 * @date: 2022/11/09
 **/

@RequestMapping("test")
@RestController
@CrossOrigin(originPatterns = "*", allowCredentials = "true", maxAge = 3600)
@Slf4j
public class TestController {

    @GetMapping()
    public R<String> test(@RequestParam(required = false)  String reqParam, @RequestParam(required = false) String reqParam2) {
        log.info("request, param:{},{}", reqParam, reqParam2);

        R<String> r = new R<String>();
        r.setContent("返回结果。。。。");
        r.setErrorCode("errorCode");
        r.setErrorExtInfo("extInfo");
        r.setErrorLevel("leve1");
        //r.setErrorMsg("msg...");
        r.setThrowable("throw");
        r.setSuccess(true);

        return r;

        //return "{\"content\":{\"currentPage\":1,\"limit\":50,\"start\":0,\"totalCount\":4,\"values\":[{\"deptFullPath\":{\"en_US\":\"友宝集团-总部-互联网产品与研发中心-互联网研发部\",\"pureEn_US\":\"友宝集团-总部-互联网产品与研发中心-互联网研发部\",\"type\":\"i18n\",\"zh_CN\":\"友宝集团-总部-互联网产品与研发中心-互联网研发部\"},\"emplId\":\"97848239\",\"name\":{\"en_US\":\"互联网研发部\",\"pureEn_US\":\"互联网研发部\",\"type\":\"i18n\",\"zh_CN\":\"互联网研发部\"}},{\"deptFullPath\":{\"en_US\":\"友宝集团-总部-互联网产品与研发中心-互联网研发部-平台研发室\",\"pureEn_US\":\"友宝集团-总部-互联网产品与研发中心-互联网研发部-平台研发室\",\"type\":\"i18n\",\"zh_CN\":\"友宝集团-总部-互联网产品与研发中心-互联网研发部-平台研发室\"},\"emplId\":\"97673323\",\"name\":{\"en_US\":\"平台研发室\",\"pureEn_US\":\"平台研发室\",\"type\":\"i18n\",\"zh_CN\":\"平台研发室\"}},{\"deptFullPath\":{\"en_US\":\"友宝集团-总部\",\"pureEn_US\":\"友宝集团-总部\",\"type\":\"i18n\",\"zh_CN\":\"友宝集团-总部\"},\"emplId\":\"97719153\",\"name\":{\"en_US\":\"总部\",\"pureEn_US\":\"总部\",\"type\":\"i18n\",\"zh_CN\":\"总部\"}},{\"deptFullPath\":{\"en_US\":\"友宝集团-总部-互联网产品与研发中心\",\"pureEn_US\":\"友宝集团-总部-互联网产品与研发中心\",\"type\":\"i18n\",\"zh_CN\":\"友宝集团-总部-互联网产品与研发中心\"},\"emplId\":\"97864184\",\"name\":{\"en_US\":\"互联网产品与研发中心\",\"pureEn_US\":\"互联网产品与研发中心\",\"type\":\"i18n\",\"zh_CN\":\"互联网产品与研发中心\"}}]},\"errorCode\":\"\",\"errorExtInfo\":null,\"errorLevel\":\"\",\"errorMsg\":\"\",\"success\":true,\"throwable\":\"\"}";
    }

    @RequestMapping("test2")
    public Map<String, Object> test2() {
        log.info("test2...........");

        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("success", true);
        map.put("data","dddddddd");
        return map;
    }
}
