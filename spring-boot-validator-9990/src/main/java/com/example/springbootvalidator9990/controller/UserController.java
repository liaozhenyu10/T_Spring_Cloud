package com.example.springbootvalidator9990.controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootvalidator9990.common.ApiException;
import com.example.springbootvalidator9990.common.R;
import com.example.springbootvalidator9990.common.ResultCode;
import com.example.springbootvalidator9990.form.UserForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author: liaozhenyu
 * @date: 2022/09/28
 **/

@RestController
@RequestMapping("user")
@Slf4j
@Validated
public class UserController {

    @PostMapping("add")
    public R add(@Valid @RequestBody UserForm userForm) {

        log.info("req param:{}", JSON.toJSONString(userForm));
        //throw new ApiException();
        return R.error(ResultCode.PARAMS_IS_INVALID);

        //return R.ok();
    }

    @PostMapping("form_data")
    public R form_data(@Valid UserForm userForm) {
        log.info("req param:{}", JSON.toJSONString(userForm));
        return R.ok();
    }

    @PostMapping("json_data")
    public R json_data(@Valid @RequestBody UserForm userForm) {
        log.info("req param:{}", JSON.toJSONString(userForm));
        return R.ok();
    }

    @RequestMapping()
    public R getUser(@RequestParam("uid") String uid) {
        return R.ok();
    }

    @RequestMapping("single")
    public R singleParam(@NotNull(message="姓名不能为空") String name, @NotNull(message="性别不能为空") String gender) {
        return R.ok();
    }
}
