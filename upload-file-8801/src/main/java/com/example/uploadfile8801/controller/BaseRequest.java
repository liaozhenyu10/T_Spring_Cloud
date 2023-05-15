package com.example.uploadfile8801.controller;

import java.io.Serializable;

/**
 * @Description:
 * @Author: chelsen
 * @Date: 2020/12/1
 **/

public class BaseRequest implements Serializable {

    private String interfaceName;
    private String appKey;
    private long timestamp;
    private String data;
    private String sign;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
