package com.zhuofengyuan.blog.blogprovidercmc.vo;

import com.zhuofengyuan.blog.blogprovidercmc.model.Product;
import lombok.Data;

import java.util.List;

@Data
public class ShopProductVo {

    private String cateName;
    private String cateId;
    private List<Product> products;
}
