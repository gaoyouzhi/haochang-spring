package com.haochang.webflux.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 描述：首页
 * @author: youzhi.gao
 * @date: 2020-12-24 15:23
 */
@Controller
public class IndexController {


    @RequestMapping("index")
    public String index(){
        return "username" + getUserName();
    }

    private String getUserName() {
        //获取当前用户登陆信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!authentication.isAuthenticated()){
            return null;
        }

        Object principal = authentication.getPrincipal();
        String username = null;
        if(principal instanceof UserDetails){
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        return username;
    }
}
