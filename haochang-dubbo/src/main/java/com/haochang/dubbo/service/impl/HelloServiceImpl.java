package com.haochang.dubbo.service.impl;

import com.haochang.dubbo.service.HelloService;

/**
 * @description: 描述：hello服务实现类
 * @author: youzhi.gao
 * @date: 2021-01-28 09:50
 */
public class HelloServiceImpl implements HelloService {
    public String sayHello(String name) {
        return "hello " + name;
    }
}
