package com.zhuofengyuan.blog.blogprovidercmc.model;

import lombok.Data;

import java.util.Date;

@Data
public class PropertyOption {
    private Long id;

    private Long propertyId;

    private String optionName;

    private Date createTime;

    private Date updateTime;

}