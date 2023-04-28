package com.example.springbootvalidator9990.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * @author: liaozhenyu
 * @date: 2022/09/28
 **/

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public R handleApiException(ApiException e) {
        log.error("接口自定义异常，异常原因:{}", e.getMsg());
        return R.error(e.getResultCode());
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<R> validateParameter(BindException e){
        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        log.error("表单传参异常，异常原因：{}", defaultMessage);
        return this.invalidParam(defaultMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<R> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        String defaultMessage = e.getBindingResult().getFieldError().getDefaultMessage();
        log.error("JSON传参异常，异常原因：{}", defaultMessage);
        return this.invalidParam(defaultMessage);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<R> handleConstraintViolationException(ConstraintViolationException e){
        log.warn("非Java Bean传参异常，异常原因：{}", e.getMessage());
        return this.invalidParam(e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<R> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.warn("缺少请求参数异常，异常原因：{}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(R.error(ResultCode.PARAMS_IS_INVALID.setArgs(new Object[]{e.getMessage()})));
    }

    private ResponseEntity<R> invalidParam(String message) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(R.error(ResultCode.PARAMS_IS_INVALID.setArgs(new Object[]{message})));
    }


}
