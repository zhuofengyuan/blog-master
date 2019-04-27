package com.zhuofengyuan.blog.blogprovidercmc.web;

import com.zhuofengyuan.blog.blogcommon.bo.RestResponseBo;
import com.zhuofengyuan.blog.blogcommon.keygen.KeyGenerator;
import com.zhuofengyuan.blog.blogprovidercmc.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;
    @Autowired
    KeyGenerator<Number> keyGenerator;

    @GetMapping("/user")
    public Principal getPrincipal(Principal user){
        return user;
    }

    @GetMapping("/list")
    public RestResponseBo findAll(@RequestParam(name = "page", defaultValue = "0") int num,
                                  @RequestParam(name = "limit", defaultValue = "10") int size) {
        return RestResponseBo.ok(this.productService.findPage(num, size), 0);
    }

    @GetMapping("/keygen")
    public Number keygen(){
        return this.keyGenerator.generateKey();
    }
}
