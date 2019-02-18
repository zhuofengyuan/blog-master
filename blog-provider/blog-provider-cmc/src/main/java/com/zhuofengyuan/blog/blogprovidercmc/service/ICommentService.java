package com.zhuofengyuan.blog.blogprovidercmc.service;

import com.zhuofengyuan.blog.blogprovidercmc.model.Comment;

import java.util.List;

public interface ICommentService {

    List<Comment> findAll();
}
