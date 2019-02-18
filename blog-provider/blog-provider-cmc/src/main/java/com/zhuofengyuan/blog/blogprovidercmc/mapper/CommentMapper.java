package com.zhuofengyuan.blog.blogprovidercmc.mapper;

import com.zhuofengyuan.blog.blogprovidercmc.model.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentMapper {
    int deleteByPrimaryKey(Integer coid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer coid);

    List<Comment> selectAll();

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}