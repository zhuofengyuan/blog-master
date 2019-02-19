package com.zhuofengyuan.blog.blogcommon.keygen;

import com.zhuofengyuan.blog.blogcommon.utils.UUID;
import org.springframework.stereotype.Component;

@Component
public class UUIDKeyGenerator implements KeyGenerator<String>{

    @Override
    public synchronized String generateKey() {
        return UUID.UU32();
    }
}
