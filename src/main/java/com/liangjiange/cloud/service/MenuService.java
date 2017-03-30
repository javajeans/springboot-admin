package com.liangjiange.cloud.service;

import com.liangjiange.cloud.model.Menu;

import java.util.List;

/**
 * @author liangjiange
 * @since 2015-12-19 11:09
 */
public interface MenuService {

    List<Menu> getMenusByUserAndParentId(Long userId, Long parentId);

    List<Menu> getFirstLevelMenusByUser(Long userId);

}
