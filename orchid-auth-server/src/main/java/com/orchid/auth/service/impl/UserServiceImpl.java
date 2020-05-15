package com.orchid.auth.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.orchid.auth.dao.UserDao;
import com.orchid.auth.entity.User;
import com.orchid.auth.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2020-04-15 15:42:54
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService, UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=super.getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
        if(user==null){
            throw new UsernameNotFoundException("用户名错误");
        }
        return user;
    }
}
