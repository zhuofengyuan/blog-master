package com.zhuofengyuan.blog.blogeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BlogEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogEurekaApplication.class, args);
    }

}

