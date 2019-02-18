package com.zhuofengyuan.blog.blogprovideruac.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhuofengyuan.blog.blogcommon.utils.FengtoosUtils;
import com.zhuofengyuan.blog.blogprovideruac.exception.TipException;
import com.zhuofengyuan.blog.blogprovideruac.mapper.UserMapper;
import com.zhuofengyuan.blog.blogprovideruac.model.User;
import com.zhuofengyuan.blog.blogprovideruac.model.vo.UserVo;
import com.zhuofengyuan.blog.blogprovideruac.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@CacheConfig(cacheNames = "userCache")
public class UserService implements IUserService {

    @Autowired
    UserMapper userDao;
    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "userCache")
    public PageInfo<User> findAll(int num, int size) {
        PageHelper.startPage(num, size);
        List<User> data = this.userDao.findAll();
        PageInfo<User> user = new PageInfo<>(data);
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(key = "'user_'+ #p0")
    public User findById(String id) {
        if (id == null) {
            return null;
        }
        return this.userDao.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    @CachePut(key = "'user_'+ #p0.id")
    public User addObject(User user) {
        String password = user.getPassword(), username = user.getUsername();
        user.setPassword(FengtoosUtils.MD5encode(username + password));
        this.userDao.insert(user);
        return this.userDao.selectByPrimaryKey(user.getUid());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    @CachePut(key = "'user_' + #p0.id")
    public User updateUser(User u) {
        this.userDao.updateByPrimaryKeySelective(u);
        // 可能只是更新某几个字段而已，所以查次数据库把数据全部拿出来全部
        return this.userDao.selectByPrimaryKey(u.getUid());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    @CacheEvict(key = "'user_' + #p0") // 删除缓存名称为userCache,key等于指定的id对应的缓存
    public void deleteById(String id) {
        this.userDao.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new TipException("用户名和密码不能为空");
        }
        UserVo vo = new UserVo();
        String pwd = this.encoder.encode(password);
        vo.setUsername(username);
        vo.setPassword(pwd);
        List<User> userList = userDao.selectByUsernameAndPassowrd(vo);
        if (userList.size() != 1) {
            throw new TipException("用户名或密码错误");
        }
        return userList.get(0);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        if(StringUtils.isEmpty(username)){
            return null;
        }
        return this.userDao.selectByUserName(username);
    }
}
