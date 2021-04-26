package com.biz.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @projectName: Week01
 * @className: RedirectController
 * @description: 页面跳转 controller
 * @author: xy
 * @time: 2021/4/20 19:29
 */
@Controller
public class RedirectController {

    @RequestMapping("/page/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/page/user-insert")
    public String userInsert(){
        return "user-insert";
    }

    @RequestMapping("/page/user-login")
    public String userLogin(){
        return "user-login";
    }

    @RequestMapping("/page/user-manage")
    public String userManage(){
        return "user-manage";
    }
    @RequestMapping("/page/role-manage")
    public String roleManage(){
        return "role-manage";
    }
    @RequestMapping("/page/permission-manage")
    public String permissionManage(){
        return "permission-manage";
    }
    @RequestMapping("/page/user-manage-update")
    public String userManageUpdate(){
        return "user-manage-update";
    }

}
