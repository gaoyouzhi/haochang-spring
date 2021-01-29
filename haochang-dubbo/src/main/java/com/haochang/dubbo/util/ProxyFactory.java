package com.haochang.dubbo.util;

import com.haochang.dubbo.protocol.Invocation;
import com.haochang.dubbo.protocol.Protocol;
import com.haochang.dubbo.protocol.ProtocolFactory;
import com.haochang.dubbo.service.HelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description: 描述：动态代理
 * @author: youzhi.gao
 * @date: 2021-01-28 18:04
 */
public class ProxyFactory {

    public static <T> T getProxy(final Class interfaceClass) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), method.getParameterTypes(), args);

                URL url = new URL("localhost", 8080);
                Protocol protocol = ProtocolFactory.getProtocol();
                String result = protocol.send(url, invocation);
                return result;
            }
        });
    }
}
