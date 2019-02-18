package com.zhuofengyuan.blog.blogprovideruacapi.service;


import com.zhuofengyuan.blog.blogprovideruacapi.service.hystrix.UacUserFeginHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "blog-provider-uac", fallback = UacUserFeginHystrix.class)
public interface UacUserFeginApi {

    @GetMapping("/api/user/get/list")
    public String findUserList();
}
