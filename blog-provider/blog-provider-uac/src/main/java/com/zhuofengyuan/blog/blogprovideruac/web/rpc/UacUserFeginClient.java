package com.zhuofengyuan.blog.blogprovideruac.web.rpc;

import com.zhuofengyuan.blog.blogprovideruac.service.IUserService;
import com.zhuofengyuan.blog.blogprovideruacapi.service.UacUserFeginApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UacUserFeginClient implements UacUserFeginApi {

    @Autowired
    IUserService userService;
    @Value("${server.port}")
    String port;

    @Override
    public String findUserList() {
//        List<User> userList = this.userService.findAll();
//        log.debug("findUserList: size = {} -> success", userList.size());
        return "success " + port;
    }
}
