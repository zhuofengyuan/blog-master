package com.zhuofengyuan.blog.blogprovidercmc.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Category implements Serializable{

    private String id;

    private String parentId;

    private String name;

    private Boolean status;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;

    private List<Category> children;

}