package com.liangjiange.cloud.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liangjiange.cloud.model.Menu;
import com.liangjiange.cloud.model.User;
import com.liangjiange.cloud.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author liangjiange
 * @since 2017-02-07 20:46
 */
@Controller
public class IndexController {

    @Autowired
    MenuService menuService;

    @RequestMapping(value = {"", "/", "index", "main"})
    public String index(HttpServletRequest request, ModelMap modelMap) {

        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();

        User user;
        if (auth.getPrincipal() instanceof UserDetails) {
            user = (User) auth.getPrincipal();
        } else {
            return "login/login";
        }

        Long userId = user.getId();
        JSONArray firstLevelNavs = new JSONArray();
        List<Menu> firstLevelMenus = menuService.getFirstLevelMenusByUser(userId);
        JSONObject homePage = new JSONObject();
        if (firstLevelMenus != null && !firstLevelMenus.isEmpty()) {
            for (int i = 0; i < firstLevelMenus.size(); i++) {
                Menu firstLevelMenu = firstLevelMenus.get(i);
                JSONObject firstLevelNav = new JSONObject();
                if (!firstLevelMenu.getHasChildMenu()) {
                    if (0 == i) {
                        homePage.put("menuId", firstLevelMenu.getId());
                        homePage.put("menuDescription", firstLevelMenu.getDescription());
                        homePage.put("url", firstLevelMenu.getUrl());
                        homePage.put("iconfont", firstLevelMenu.getIconfont());
                    }
                    firstLevelNav.put("isParent", false);
                    firstLevelNav.put("menuId", firstLevelMenu.getId());
                    firstLevelNav.put("menuDescription", firstLevelMenu.getDescription());
                    firstLevelNav.put("url", firstLevelMenu.getUrl());
                    firstLevelNav.put("iconfont", firstLevelMenu.getIconfont());
                    firstLevelNavs.add(firstLevelNav);
                } else {
                    firstLevelNav.put("isParent", true);
                    firstLevelNav.put("menuId", firstLevelMenu.getId());
                    firstLevelNav.put("menuDescription", firstLevelMenu.getDescription());
                    firstLevelNav.put("iconfont", firstLevelMenu.getIconfont());
                    List<Menu> secondLevelMenus = menuService.getMenusByUserAndParentId(userId, firstLevelMenu.getId());
                    JSONArray secondLevelNavs = new JSONArray();
                    for (int j = 0; j < secondLevelMenus.size(); j++) {
                        Menu secondLevelMenu = secondLevelMenus.get(j);
                        JSONObject secondLevelNav = new JSONObject();
                        if (!secondLevelMenu.getHasChildMenu()) {
                            if (homePage.isEmpty() && j == 0) {
                                homePage.put("menuId", secondLevelMenu.getId());
                                homePage.put("menuDescription", secondLevelMenu.getDescription());
                                homePage.put("url", secondLevelMenu.getUrl());
                                homePage.put("iconfont", secondLevelMenu.getIconfont());
                            }
                            secondLevelNav.put("isParent", false);
                            secondLevelNav.put("menuId", secondLevelMenu.getId());
                            secondLevelNav.put("menuDescription", secondLevelMenu.getDescription());
                            secondLevelNav.put("url", secondLevelMenu.getUrl());
                            secondLevelNav.put("iconfont", secondLevelMenu.getIconfont());
                            secondLevelNavs.add(secondLevelNav);
                        } else {
                            secondLevelNav.put("isParent", true);
                            secondLevelNav.put("menuId", secondLevelMenu.getId());
                            secondLevelNav.put("menuDescription", secondLevelMenu.getDescription());
                            secondLevelNav.put("iconfont", secondLevelMenu.getIconfont());
                            List<Menu> thirdLevelMenus = menuService.getMenusByUserAndParentId(userId,
                                    secondLevelMenu.getId());
                            JSONArray thirdLevelNavs = new JSONArray();
                            for (int k = 0; k < thirdLevelMenus.size(); k++) {
                                Menu thirdLevelMenu = thirdLevelMenus.get(k);
                                if (homePage.isEmpty() && k == 0) {
                                    homePage.put("menuId", thirdLevelMenu.getId());
                                    homePage.put("menuDescription", thirdLevelMenu.getDescription());
                                    homePage.put("url", thirdLevelMenu.getUrl());
                                    homePage.put("iconfont", thirdLevelMenu.getIconfont());
                                }
                                JSONObject thirdLevelNav = new JSONObject();
                                thirdLevelNav.put("menuId", thirdLevelMenu.getId());
                                thirdLevelNav.put("menuDescription", thirdLevelMenu.getDescription());
                                thirdLevelNav.put("url", thirdLevelMenu.getUrl());
                                thirdLevelNav.put("iconfont", thirdLevelMenu.getIconfont());
                                thirdLevelNavs.add(thirdLevelNav);
                            }
                            secondLevelNav.put("thirdLevelNavs", thirdLevelNavs);
                            secondLevelNavs.add(secondLevelNav);
                        }
                    }
                    firstLevelNav.put("secondLevelNavs", secondLevelNavs);
                    firstLevelNavs.add(firstLevelNav);
                }
            }
        }
        modelMap.put("homePage", homePage);
        modelMap.put("firstLevelNavs", firstLevelNavs);
        return "index";
    }

}
