package com.liangjiange.cloud.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liangjiange
 * @since 2017-02-07 20:46
 */
@Controller
@RequestMapping("manage")
public class RoleManageController {

    @RequestMapping("role")
    public String roleList() {
        return "role/role-list";
    }

}
