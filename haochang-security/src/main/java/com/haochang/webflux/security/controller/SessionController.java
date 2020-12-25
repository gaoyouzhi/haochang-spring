package com.haochang.webflux.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 描述：session控制器
 * @author: youzhi.gao
 * @date: 2020-12-24 15:40
 */
@Controller
@RequestMapping("/session")
public class SessionController {


    @RequestMapping("/invalid")
    @ResponseBody
    public String invalid(){
        return "session失效";
    }
}
