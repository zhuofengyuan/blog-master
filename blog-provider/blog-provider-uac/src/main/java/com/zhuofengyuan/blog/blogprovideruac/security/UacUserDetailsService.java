package com.zhuofengyuan.blog.blogprovideruac.security;

import com.zhuofengyuan.blog.blogcommon.security.SecurityUser;
import com.zhuofengyuan.blog.blogprovideruac.mapper.AuthorizationMapper;
import com.zhuofengyuan.blog.blogprovideruac.model.Authorization;
import com.zhuofengyuan.blog.blogprovideruac.model.User;
import com.zhuofengyuan.blog.blogprovideruac.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UacUserDetailsService implements UserDetailsService {

    @Autowired
    IUserService userService;
    @Autowired
    AuthorizationMapper authorizationDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User entity = this.userService.findByUsername(username);
        if(entity == null){
            throw new UsernameNotFoundException("用户名认证失败");
        }
        return this.createSecurityUser(entity);
    }

    private SecurityUser createSecurityUser(User entity){
        String id = entity.getId();
        List<Authorization> auths = this.authorizationDao.selectByUserId(id);

        List<GrantedAuthority> authorizations = auths.stream().filter(a -> StringUtils.isNotEmpty(a.getCode()))
                .map(a -> new SimpleGrantedAuthority(a.getCode())).collect(Collectors.toList());
        return new SecurityUser(authorizations, entity.getId(), entity.getScreenName(), entity.getUsername(), entity.getPassword());
    }
}
