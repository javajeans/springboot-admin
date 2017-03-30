package com.liangjiange.cloud.service.impl;

import com.liangjiange.cloud.mapper.MenuMapper;
import com.liangjiange.cloud.model.Menu;
import com.liangjiange.cloud.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangjiange
 * @since 2015-12-19 11:09
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getMenusByUserAndParentId(Long userId, Long parentId) {
        return menuMapper.getMenusByUserAndParentId(userId, parentId);
    }

    @Override
    public List<Menu> getFirstLevelMenusByUser(Long userId) {
        return menuMapper.getFirstLevelMenusByUser(userId);
    }
}
