package com.zhuofengyuan.blog.blogprovidercmc.web;

import com.zhuofengyuan.blog.blogcommon.bo.RestResponseBo;
import com.zhuofengyuan.blog.blogcommon.constant.WebConst;
import com.zhuofengyuan.blog.blogprovidercmc.model.Comment;
import com.zhuofengyuan.blog.blogprovidercmc.service.ICommentService;
import com.zhuofengyuan.blog.blogprovideruacapi.service.UacUserFeginApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/cmc")
public class HelloController {

    @Value("${server.port}")
    String port;
    @Autowired
    UacUserFeginApi userFeginApi;
    @Autowired
    ICommentService commentService;

    @GetMapping("/hello")
    public String hello(HttpServletRequest req){
        req.getSession().setAttribute("user", "123456");
        return "Hello this is CMC Provider " + port;
    }

    @GetMapping("/user")
    public Principal getPrincipal(Principal user){
        return user;
    }

    @GetMapping("/list")
    public List<Comment> findAll(){
        return this.commentService.findAll();
    }


    @GetMapping("/fegin")
    public String fegin(){
        return userFeginApi.findUserList();
    }

    @GetMapping("/getSessionId")
    public RestResponseBo getSessionId(HttpServletRequest request){
        HttpSession session = request.getSession();
        return RestResponseBo.ok(session.getAttribute(WebConst.LOGIN_SESSION_KEY));
    }
}
