package com.zhuofengyuan.blog.blogprovideruac.service;

import com.github.pagehelper.PageInfo;
import com.zhuofengyuan.blog.blogprovideruac.model.User;

import java.util.List;

public interface IUserService {

    /**
     * 查找所有的用户
     * @return
     */
    PageInfo<User> findAll(int num, int size);

    /**
     * 根据ID查找用户
     * @param id
     * @return
     */
    User findById(String id);

    /**
     * 新增用户
     * @param user
     * @return
     */
    User addObject(User user);

    /**
     * 编辑用户
     * @param user
     * @return
     */
    User updateUser(User user);

    /**
     * 根据ID删除用户
     * @param id
     */
    void deleteById(String id);

    /**
     * 用戶登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);
}
