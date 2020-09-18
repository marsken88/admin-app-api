package org.marsken.plantform.domain.service.impl;

import org.marsken.plantform.domain.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author ：MarsKen
 * @date ：Created in 2020/9/14 11:07 下午
 * @description：用户详情类
 * @modified By：
 * @version: 1.0.0$
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        UserEntity userEntity = UserEntity.builder().username(username).password("$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6").build();
        return userEntity;
    }
}
