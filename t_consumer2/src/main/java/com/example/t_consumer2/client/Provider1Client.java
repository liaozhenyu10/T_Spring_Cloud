package com.example.t_consumer2.client;


import com.example.t_consumer2.hystrix.HystrixClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//对应背调用项目的spring.application.name
@FeignClient(name = "provider-1", fallbackFactory = HystrixClientFallbackFactory.class)
public interface Provider1Client {

    @RequestMapping(method = RequestMethod.GET, value = "provider1/greet")
    String greek();

    @RequestMapping(method = RequestMethod.GET, value = "provider1/testHystrix")
    String testHystrix(@RequestParam("id") Integer id);


//    class PFallBack implements Provider1Client {
//
//        @Override
//        public String greek() {
//            return "当前服务不可用";
//        }
//
//        @Override
//        public String testHystrix(Integer id) {
//            return "服务降级";
//        }
//
//    }
}
