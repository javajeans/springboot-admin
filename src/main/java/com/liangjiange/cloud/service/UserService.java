package com.liangjiange.cloud.service;

import com.liangjiange.cloud.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangjiange
 * @since 2015-12-19 11:09
 */
@Service
public interface UserService {

    User getById(Long id);

    void deleteById(Long id);

    void save(User user);


    List<User> getUsersByFilters(String username);


    User getUserByUsername(String username);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
