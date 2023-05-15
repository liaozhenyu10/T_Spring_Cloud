package com.example.springdatajpa9006.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: liaozhenyu
 * @date: 2022/09/27
 **/
public class Test {
    public static void main(String[] args) throws JsonProcessingException {
        RawBean bean = new RawBean("My bean", "{\"attr\":false}");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = objectMapper.writeValueAsString(bean);

        System.out.println(result);
    }

    @Data
    @AllArgsConstructor
    @JsonRootName(value = "obj")
    public static class RawBean {

        @JsonProperty("firstName")
        public String name;
        @JsonRawValue
        public String attrs;
    }
}
