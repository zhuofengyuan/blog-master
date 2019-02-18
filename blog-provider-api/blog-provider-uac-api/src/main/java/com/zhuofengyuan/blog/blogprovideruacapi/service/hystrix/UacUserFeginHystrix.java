package com.zhuofengyuan.blog.blogprovideruacapi.service.hystrix;

import com.zhuofengyuan.blog.blogprovideruacapi.service.UacUserFeginApi;
import org.springframework.stereotype.Component;

@Component
public class UacUserFeginHystrix implements UacUserFeginApi {

    @Override
    public String findUserList() {
        return "application is error";
    }
}
