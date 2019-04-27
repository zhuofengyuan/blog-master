package com.zhuofengyuan.blog.blogprovidercmc.service;

import com.github.pagehelper.PageInfo;
import com.zhuofengyuan.blog.blogprovidercmc.model.Product;
import com.zhuofengyuan.blog.blogprovidercmc.vo.ShopProductVo;

import java.util.List;

public interface IProductService {

    PageInfo<Product> findPage(int num, int size);

    Product findById(Long id);

    Product addProduct(Product object);

    Product updateProduct(Product object);

    void deleteById(Long id);

    List<ShopProductVo> findAll();
}
