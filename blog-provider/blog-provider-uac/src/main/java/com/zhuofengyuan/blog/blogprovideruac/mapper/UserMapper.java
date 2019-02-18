package com.zhuofengyuan.blog.blogprovideruac.mapper;

import com.zhuofengyuan.blog.blogprovideruac.model.User;
import com.zhuofengyuan.blog.blogprovideruac.model.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {

    int deleteByPrimaryKey(String uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(@Param("id") String uid);

    User selectByUserName(@Param("username") String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findAll();

    /**
     * 根据用户名密码查找用户
     * @param record
     * @return
     */
    List<User> selectByUsernameAndPassowrd(UserVo record);
}