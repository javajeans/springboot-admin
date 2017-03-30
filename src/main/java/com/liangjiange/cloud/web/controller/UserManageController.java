package com.liangjiange.cloud.web.controller;

import com.github.pagehelper.PageHelper;
import com.liangjiange.cloud.model.User;
import com.liangjiange.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author liangjiange
 * @since 2017-02-07 20:46
 */
@Controller
@RequestMapping("manage")
public class UserManageController {

    @Autowired
    UserService userService;

    @RequestMapping("user")
    public String userList(HttpServletRequest request, HttpServletResponse response, ModelMap modelMaps,
                           @RequestParam(required = false, defaultValue = "0") Boolean ajaxSearch,
                           @RequestParam(required = false, defaultValue = "1") Integer currentPage,
                           @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                           @RequestParam(required = false) String username) {

        PageHelper.startPage(currentPage, pageSize);
        List<User> users = userService.getUsersByFilters(username);
        modelMaps.put("users", users);
        return ajaxSearch ? "user/user-list :: #table-content" : "user/user-list";

    }

}
