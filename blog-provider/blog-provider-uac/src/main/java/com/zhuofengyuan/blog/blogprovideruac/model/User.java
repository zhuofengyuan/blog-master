package com.zhuofengyuan.blog.blogprovideruac.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable{

    private static final long serialVersionUID = -7472802841628712694L;

    private String uid;

    private String username;

    private String password;

    private String email;

    private String homeUrl;

    private String screenName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date created;

    private Integer activated;

    private Integer logged;

    private String groupName;
}