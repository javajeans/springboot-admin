package com.liangjiange.cloud.mapper;

import com.liangjiange.cloud.model.Menu;
import com.liangjiange.cloud.util.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper extends MyMapper<Menu> {

    List<Menu> getMenusByUserAndParentId(@Param("userId") Long userId, @Param("parentId") Long parentId);

    List<Menu> getFirstLevelMenusByUser(@Param("userId") Long userId);

}