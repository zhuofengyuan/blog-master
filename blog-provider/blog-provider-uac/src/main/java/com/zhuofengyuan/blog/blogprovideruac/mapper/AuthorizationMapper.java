package com.zhuofengyuan.blog.blogprovideruac.mapper;

import com.zhuofengyuan.blog.blogprovideruac.model.Authorization;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AuthorizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Authorization record);

    int insertSelective(Authorization record);

    Authorization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Authorization record);

    int updateByPrimaryKey(Authorization record);

    List<Authorization> selectByUserId(@Param("userId") String userId);
}