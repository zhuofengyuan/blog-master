package com.zhuofengyuan.blog.blogprovideruac.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVo implements Serializable {

    private static final long serialVersionUID = -7472802841628712694L;

    private String uid;

    private String username;

    private String password;

    private String email;

    private String homeUrl;

    private String screenName;

    private Integer created;

    private Integer activated;

    private Integer logged;

    private String groupName;
}