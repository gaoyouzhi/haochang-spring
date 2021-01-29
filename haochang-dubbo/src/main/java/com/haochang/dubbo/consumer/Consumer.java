package com.haochang.dubbo.consumer;

import com.haochang.dubbo.protocol.Invocation;
import com.haochang.dubbo.protocol.Protocol;
import com.haochang.dubbo.protocol.ProtocolFactory;
import com.haochang.dubbo.service.HelloService;
import com.haochang.dubbo.util.URL;
import com.haochang.dubbo.util.ProxyFactory;

/**
 * @description: 描述：服务消费者
 * @author: youzhi.gao
 * @date: 2021-01-28 09:48
 */
public class Consumer {
    public static void main(String[] args) {
        HelloService proxyObj = ProxyFactory.getProxy(HelloService.class);
        String result = proxyObj.sayHello("xxx");
        System.out.println(result);
    }
}
