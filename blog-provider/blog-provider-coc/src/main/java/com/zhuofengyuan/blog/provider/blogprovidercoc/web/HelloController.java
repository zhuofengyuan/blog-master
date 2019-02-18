package com.zhuofengyuan.blog.provider.blogprovidercoc.web;

import com.zhuofengyuan.blog.blogcommon.bo.RestResponseBo;
import com.zhuofengyuan.blog.blogcommon.constant.WebConst;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class HelloController {

    @GetMapping("/getSessionId")
    public RestResponseBo getSessionId(HttpServletRequest request){
        HttpSession session = request.getSession();
        return RestResponseBo.ok(session.getAttribute(WebConst.LOGIN_SESSION_KEY));
    }
}
