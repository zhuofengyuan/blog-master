package com.zhuofengyuan.blog.blogprovidercmc.web.shop;

import com.zhuofengyuan.blog.blogcommon.bo.RestResponseBo;
import com.zhuofengyuan.blog.blogprovidercmc.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop/product")
public class ShopProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/list")
    public RestResponseBo findAll(){
        return RestResponseBo.ok(this.productService.findAll(), 200);
    }
}
