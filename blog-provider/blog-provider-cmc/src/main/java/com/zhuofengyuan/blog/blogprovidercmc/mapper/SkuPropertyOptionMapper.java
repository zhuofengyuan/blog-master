package com.zhuofengyuan.blog.blogprovidercmc.mapper;


import com.zhuofengyuan.blog.blogprovidercmc.model.SkuPropertyOption;
import org.springframework.stereotype.Component;

@Component
public interface SkuPropertyOptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SkuPropertyOption record);

    int insertSelective(SkuPropertyOption record);

    SkuPropertyOption selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SkuPropertyOption record);

    int updateByPrimaryKey(SkuPropertyOption record);
}