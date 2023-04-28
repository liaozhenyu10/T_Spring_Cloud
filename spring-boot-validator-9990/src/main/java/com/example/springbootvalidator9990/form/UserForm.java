package com.example.springbootvalidator9990.form;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author: liaozhenyu
 * @date: 2022/09/28
 **/

@Data
public class UserForm {
    @NotNull(message = "姓名不能为空")
    private String username;

    private Integer age;

    private String phone;

    private String email;

    private String address;

    @Size(min = 1, max = 2, message = "别名个数必须在1到2之间")
    @NotEmpty(message = "别名不能为空")
    private List<String> aliasList;

}
