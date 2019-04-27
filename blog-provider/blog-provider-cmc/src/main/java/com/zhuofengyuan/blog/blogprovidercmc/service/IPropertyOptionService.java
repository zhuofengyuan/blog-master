package com.zhuofengyuan.blog.blogprovidercmc.service;

import com.zhuofengyuan.blog.blogprovidercmc.model.PropertyOption;

import java.util.List;

public interface IPropertyOptionService {

    List<PropertyOption> findAll();

    PropertyOption findById(Long id);

    PropertyOption addPropertyOption(PropertyOption object);

    PropertyOption updatePropertyOption(PropertyOption object);

    void deleteById(Long id);
}
