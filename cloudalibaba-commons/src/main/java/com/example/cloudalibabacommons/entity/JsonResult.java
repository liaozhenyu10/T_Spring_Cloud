package com.example.cloudalibabacommons.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: liaozhenyu
 * @date: 2022/04/13
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult<T> {
    private Integer code;
    private T data;
}
