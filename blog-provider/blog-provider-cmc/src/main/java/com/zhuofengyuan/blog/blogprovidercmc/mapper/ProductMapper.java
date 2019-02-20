package com.zhuofengyuan.blog.blogprovidercmc.mapper;

import com.zhuofengyuan.blog.blogprovidercmc.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectByCategory(Long categoryId);

    Product selectByPrimaryKeyWithSku(Long id);
}