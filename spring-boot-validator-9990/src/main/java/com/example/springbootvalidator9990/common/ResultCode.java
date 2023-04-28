package com.example.springbootvalidator9990.common;

import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.util.StringUtils;

public enum ResultCode {

    SUCCESS(200, "Success"),//成功
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),//未认证
    NOT_FOUND(404, "Not Found"),//接口不存在
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),//服务器内部错误
    METHOD_NOT_ALLOWED(405,"Method Not Allowed"),

    PARAMS_IS_INVALID(100001, "参数错误"),
    ;

    private int code;
    private  String msg;
    private Object[] args;

    private MessageSourceAccessor msgSourceAccessor = MessageSourceUtil.getAccessor();

    ResultCode(int code) {
        this.code = code;
    }

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        String message = msgSourceAccessor.getMessage(this.name(), this.args, "");
        if(StringUtils.hasText(message)) {
            return message;
        }
        return StringUtils.hasText(this.msg) ? this.msg : this.name();
    }

    public ResultCode setArgs(Object[] args) {
        this.args = args;
        return this;
    }
}
