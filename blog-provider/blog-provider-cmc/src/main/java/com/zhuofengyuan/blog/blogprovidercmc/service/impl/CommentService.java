package com.zhuofengyuan.blog.blogprovidercmc.service.impl;

import com.zhuofengyuan.blog.blogprovidercmc.mapper.CommentMapper;
import com.zhuofengyuan.blog.blogprovidercmc.model.Comment;
import com.zhuofengyuan.blog.blogprovidercmc.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "commentCache")
public class CommentService implements ICommentService {

    @Autowired
    CommentMapper commentDao;

    @Override
    @CachePut(value = "commentCache")
    public List<Comment> findAll() {
        return this.commentDao.selectAll();
    }
}
