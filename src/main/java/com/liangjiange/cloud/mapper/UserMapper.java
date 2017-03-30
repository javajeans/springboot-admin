package com.liangjiange.cloud.mapper;

import com.liangjiange.cloud.model.User;
import com.liangjiange.cloud.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends MyMapper<User> {

    List<User> getUsersByFilters(@Param("username") String username);

    User getUserByUsername(@Param("username") String username);

}