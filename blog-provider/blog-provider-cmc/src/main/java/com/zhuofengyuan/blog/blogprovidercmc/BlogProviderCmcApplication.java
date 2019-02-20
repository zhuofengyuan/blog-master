package com.zhuofengyuan.blog.blogprovidercmc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.zhuofengyuan.blog.blogprovideruacapi.service"})
@EnableTransactionManagement
@MapperScan("com.zhuofengyuan.blog.blogprovidercmc.mapper")
@SpringBootApplication(scanBasePackages = "com.zhuofengyuan.blog")
public class BlogProviderCmcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogProviderCmcApplication.class, args);
    }

}

