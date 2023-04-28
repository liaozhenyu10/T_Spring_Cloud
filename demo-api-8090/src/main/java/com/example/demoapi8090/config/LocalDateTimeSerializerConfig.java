package com.example.demoapi8090.config;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

/**
 * @author: liaozhenyu
 * @date: 2022/12/02
 **/

@Configuration
public class LocalDateTimeSerializerConfig {

    @Value("${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
    private String pattern;

    public LocalDateTimeSerializer localDateTimeSerializer() {
        return new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern));
    }

    public static void main(String[] args) {
        Double aDouble = Double.valueOf("18320902691");


        DecimalFormat decimalFormat = new DecimalFormat("#");

        System.out.println(decimalFormat.format(aDouble));
    }
}
