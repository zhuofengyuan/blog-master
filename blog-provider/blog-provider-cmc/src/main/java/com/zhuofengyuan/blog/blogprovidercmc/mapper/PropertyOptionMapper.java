package com.zhuofengyuan.blog.blogprovidercmc.mapper;


import com.zhuofengyuan.blog.blogprovidercmc.model.PropertyOption;
import org.springframework.stereotype.Component;

@Component
public interface PropertyOptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PropertyOption record);

    int insertSelective(PropertyOption record);

    PropertyOption selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PropertyOption record);

    int updateByPrimaryKey(PropertyOption record);
}