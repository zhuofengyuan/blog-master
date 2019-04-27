package com.zhuofengyuan.blog.blogprovidercmc.mapper;


import com.zhuofengyuan.blog.blogprovidercmc.model.Property;
import org.springframework.stereotype.Component;

@Component
public interface PropertyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Property record);

    int insertSelective(Property record);

    Property selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Property record);

    int updateByPrimaryKey(Property record);
}