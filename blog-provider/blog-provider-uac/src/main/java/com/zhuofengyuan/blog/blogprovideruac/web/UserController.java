package com.zhuofengyuan.blog.blogprovideruac.web;

import com.github.pagehelper.PageInfo;
import com.zhuofengyuan.blog.blogcommon.bo.RestResponseBo;
import com.zhuofengyuan.blog.blogcommon.constant.WebConst;
import com.zhuofengyuan.blog.blogprovideruac.model.User;
import com.zhuofengyuan.blog.blogprovideruac.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public RestResponseBo findAll(@RequestParam(name = "page", defaultValue = "0") int num,
                                  @RequestParam(name = "limit", defaultValue = "10") int size) {
        return RestResponseBo.ok(this.userService.findAll(num, size), 0);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") String id) {
        return this.userService.findById(id);
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @PostMapping("/add")
    public RestResponseBo addObject(User user) {
        Assert.notNull(user.getUsername(), "请输入用户名");
        Assert.notNull(user.getPassword(), "请输入密码");
        User u = this.userService.addObject(user);
        return RestResponseBo.ok(u.getId());
    }

    @GetMapping("/login")
    public RestResponseBo login(@RequestParam String username,
                                @RequestParam String password,
                                @RequestParam(required = false) String remeber_me,
                                HttpServletRequest request,
                                HttpServletResponse response) {
//        User user = this.userService.login(username, password);
        request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, "123456");
        return RestResponseBo.ok(request.getSession().getId());
    }

    @PreAuthorize("hasAnyAuthority('query')")
    @GetMapping("/getSessionId")
    public RestResponseBo getSessionId(HttpServletRequest request, String key) {
        HttpSession session = request.getSession();
        return RestResponseBo.ok(session.getAttribute(key == null ? WebConst.LOGIN_SESSION_KEY : key));
    }

    @PutMapping("/{id}")
    public String updateObject(@PathVariable String id, String username) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user.getId() + "   " + user.getUsername();
    }

    @DeleteMapping("/{id}")
    public String deleteObject(@PathVariable String id) {
        this.deleteObject(id);
        return "success";
    }

    @GetMapping("/principal")
    public Principal getPrincipal(Principal user) {
        return user;
    }

}
