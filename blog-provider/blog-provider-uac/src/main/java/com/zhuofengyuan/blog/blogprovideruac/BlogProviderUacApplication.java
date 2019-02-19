package com.zhuofengyuan.blog.blogprovideruac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.zhuofengyuan.blog")
@SpringCloudApplication
@MapperScan("com.zhuofengyuan.blog.blogprovideruac.mapper")
public class BlogProviderUacApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogProviderUacApplication.class, args);
    }

}

