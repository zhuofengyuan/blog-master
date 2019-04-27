package com.zhuofengyuan.blog.blogprovidercmc.service;

import com.zhuofengyuan.blog.blogprovidercmc.model.ProductSku;

import java.util.List;

public interface IProductSkuService {

    List<ProductSku> findAll();

    ProductSku findById(Long id);

    ProductSku addProductSku(ProductSku object);

    ProductSku updateProductSku(ProductSku object);

    void deleteById(Long id);
}
