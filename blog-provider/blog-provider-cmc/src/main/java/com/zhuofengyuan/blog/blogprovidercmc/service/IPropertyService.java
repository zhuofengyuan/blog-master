package com.zhuofengyuan.blog.blogprovidercmc.service;

import com.zhuofengyuan.blog.blogprovidercmc.model.Property;

import java.util.List;

public interface IPropertyService {

    List<Property> findAll();

    Property findById(Long id);

    Property addProperty(Property object);

    Property updateProperty(Property object);

    void deleteById(Long id);
}
