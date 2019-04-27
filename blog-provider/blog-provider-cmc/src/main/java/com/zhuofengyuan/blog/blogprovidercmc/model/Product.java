package com.zhuofengyuan.blog.blogprovidercmc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class Product implements Serializable{

    private Long id;

    private Long categoryId;

    private String categoryName;

    private Long brandId;

    private String brandName;

    private String spuName;

    private BigDecimal price;

    private Byte status;

    private List<ProductSku> skuList;

    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
}