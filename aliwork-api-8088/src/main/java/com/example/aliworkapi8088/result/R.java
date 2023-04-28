package com.example.aliworkapi8088.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: liaozhenyu
 * @date: 2022/11/10
 **/

@Data
public class R<T> implements Serializable {

    private T content;

    private Boolean success;

    private String errorCode;

    private String errorExtInfo;

    private String errorLevel;

    private String errorMsg;

    private String throwable;

}
