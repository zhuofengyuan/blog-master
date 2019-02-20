package com.zhuofengyuan.blog.blogprovidercmc.web;

import com.zhuofengyuan.blog.blogcommon.bo.RestResponseBo;
import com.zhuofengyuan.blog.blogprovidercmc.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Value("${server.port}")
    String port;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("/user")
    public Principal getPrincipal(Principal user){
        return user;
    }

    @GetMapping("/list")
    public RestResponseBo findAll(){
        return RestResponseBo.ok(this.categoryService.findAll(), 200);
    }

    @GetMapping("/tree")
    public RestResponseBo findTree(){
        return RestResponseBo.ok(this.categoryService.findTree(), 200);
    }

}
