package com.zhuofengyuan.blog.blogtemplate.web.admin;

import com.zhuofengyuan.blog.blogcommon.bo.RestResponseBo;
import com.zhuofengyuan.blog.blogcommon.constant.WebConst;
import com.zhuofengyuan.blog.blogtemplate.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @GetMapping("/login")
    public String loginPage(){
        return "admin/login";
    }

    @GetMapping("/test")
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("user", 123);
        return "admin/test";
    }

    @GetMapping("/index")
    public String indexPage(){
        return "admin/index";
    }

    @GetMapping("/getSessionId")
    public @ResponseBody RestResponseBo getSessionId(HttpServletRequest request){
        HttpSession session = request.getSession();
        return RestResponseBo.ok(session.getAttribute(WebConst.LOGIN_SESSION_KEY));
    }
}
