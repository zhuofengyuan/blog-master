package com.zhuofengyuan.blog.blogprovidercmc.service;

import com.zhuofengyuan.blog.blogprovidercmc.model.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    List<Category> findTree();

    Category findById(String id);

    Category addCategory(Category object);

    Category updateCategory(Category object);

    void deleteById(String id);
}
