package com.zhuofengyuan.blog.blogprovidercmc.mapper;

import com.zhuofengyuan.blog.blogprovidercmc.model.Product;
import com.zhuofengyuan.blog.blogprovidercmc.vo.ShopProductVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectByCategory(Long categoryId);

    List<Product> selectAll();

    List<ShopProductVo> selectShop();

    Product selectByPrimaryKeyWithSku(Long id);
}