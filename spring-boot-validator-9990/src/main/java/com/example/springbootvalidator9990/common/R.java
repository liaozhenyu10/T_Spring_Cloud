package com.example.springbootvalidator9990.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

/**
 * @author: liaozhenyu
 * @date: 2022/09/27
 **/

@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    private long ts;

    @JsonIgnore
    private ResultCode resultCode;

    public R() {
        this.setResultCode(ResultCode.SUCCESS);
    }

    public R(T data) {
        this.setResultCode(ResultCode.SUCCESS);
        this.data = data;
    }

    public R(ResultCode resultCode) {
        this.setResultCode(resultCode);
    }

    public static R ok() {
        return new R();
    }

    public R data(T data) {
        this.data = data;
        return this;
    }

    public static R error(ResultCode resultCode) {
        return new R(resultCode);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.ts = System.currentTimeMillis();
    }
}
