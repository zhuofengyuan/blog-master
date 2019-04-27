package com.zhuofengyuan.blog.blogprovidercmc.config;

import com.zhuofengyuan.blog.blogcommon.keygen.KeyGenerator;
import com.zhuofengyuan.blog.blogcommon.keygen.SnowFlakeKeyGenerator;
import com.zhuofengyuan.blog.blogcommon.keygen.UUIDKeyGenerator;
import com.zhuofengyuan.blog.blogcommon.keygen.WorkerIDSenquence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeygenConfig {

    @Bean("snowFlakeKeyGenerator")
    public KeyGenerator<Number> snowFlakeKeyGenerator(){
        return new SnowFlakeKeyGenerator();
    }

    @Bean("uuidKeyGenerator")
    public KeyGenerator<String> uuidGenerator(){
        return new UUIDKeyGenerator();
    }

    @Bean
    public WorkerIDSenquence getZKConnect(){return new WorkerIDSenquence();}
}
