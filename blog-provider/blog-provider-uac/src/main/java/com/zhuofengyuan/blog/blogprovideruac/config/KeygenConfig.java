package com.zhuofengyuan.blog.blogprovideruac.config;

import com.zhuofengyuan.blog.blogcommon.keygen.KeyGenerator;
import com.zhuofengyuan.blog.blogcommon.keygen.SnowFlakeKeyGenerator;
import com.zhuofengyuan.blog.blogcommon.keygen.UUIDKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeygenConfig {

    @Bean("uuidKeyGenerator")
    public KeyGenerator<String> uuidGenerator(){
        return new UUIDKeyGenerator();
    }
}
