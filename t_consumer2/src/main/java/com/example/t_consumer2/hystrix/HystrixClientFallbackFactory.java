package com.example.t_consumer2.hystrix;

import com.example.t_consumer2.client.Provider1Client;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author: liaozhenyu
 * @date: 2022/03/24
 **/

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<Provider1Client> {


    @Override
    public Provider1Client create(Throwable cause) {
        return new Provider1Client() {
            @Override
            public String greek() {
                return "降级处理....";
            }

            @Override
            public String testHystrix(Integer id) {
                return "降级xxx";
            }
        };
    }
}
