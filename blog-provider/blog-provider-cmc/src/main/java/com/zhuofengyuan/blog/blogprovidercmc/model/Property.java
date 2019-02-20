package com.zhuofengyuan.blog.blogprovidercmc.model;

import lombok.Data;

import java.util.Date;


@Data
public class Property {
    private Long id;

    private Long categoryId;

    private String propertyName;

    private Date createTime;

    private Date updateTime;

}