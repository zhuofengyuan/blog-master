package com.zhuofengyuan.blog.blogprovidercmc.service;

import com.zhuofengyuan.blog.blogprovidercmc.model.SkuPropertyOption;

import java.util.List;

public interface ISkuPropertyOptionService {

    List<SkuPropertyOption> findAll();

    SkuPropertyOption findById(Long id);

    SkuPropertyOption addSkuPropertyOption(SkuPropertyOption object);

    SkuPropertyOption updateSkuPropertyOption(SkuPropertyOption object);

    void deleteById(Long id);
}
