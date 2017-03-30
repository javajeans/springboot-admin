package com.liangjiange.cloud.service.impl;

import com.liangjiange.cloud.mapper.UserMapper;
import com.liangjiange.cloud.model.User;
import com.liangjiange.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liangjiange on 2017/3/11.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    public User getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public void save(User user) {
        if (user.getId() != null) {
            userMapper.updateByPrimaryKey(user);
        } else {
            userMapper.insert(user);
        }
    }


    public List<User> getUsersByFilters(String username) {
        return userMapper.getUsersByFilters(username);
    }


    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user;
        try {
            user = this.getUserByUsername(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("user select fail");
        }
        if (user == null) {
            throw new UsernameNotFoundException("no user found");
        } else {
            try {
                //List<UserRole> roles = userRoleService.getRoleByUser(user);
                //return new MyUserDetails(user, roles);
                return user;
            } catch (Exception e) {
                throw new UsernameNotFoundException("user role select fail");
            }
        }
    }

}
