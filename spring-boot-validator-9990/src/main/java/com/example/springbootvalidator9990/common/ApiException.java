package com.example.springbootvalidator9990.common;

/**
 * @author: liaozhenyu
 * @date: 2022/09/28
 **/
public class ApiException extends RuntimeException {
    private ResultCode resultCode;
    private int code;
    private String msg;

    public ApiException() {
        this.setResultCode(ResultCode.INTERNAL_SERVER_ERROR);
    }

    public ApiException(ResultCode resultCode) {
        this.setResultCode(resultCode);
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
