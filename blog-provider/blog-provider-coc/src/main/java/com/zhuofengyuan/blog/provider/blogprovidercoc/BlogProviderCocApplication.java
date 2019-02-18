package com.zhuofengyuan.blog.provider.blogprovidercoc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@MapperScan("com.zhuofengyuan.blog.blogprovidercoc.mapper")
@SpringBootApplication(scanBasePackages = "com.zhuofengyuan.blog")
public class BlogProviderCocApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogProviderCocApplication.class, args);
	}

}

