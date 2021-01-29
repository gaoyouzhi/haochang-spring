package com.haochang.dubbo.provider;


import com.haochang.dubbo.protocol.Protocol;
import com.haochang.dubbo.protocol.ProtocolFactory;
import com.haochang.dubbo.regist.LocalRegister;
import com.haochang.dubbo.regist.RemoteRegister;
import com.haochang.dubbo.service.HelloService;
import com.haochang.dubbo.service.impl.HelloServiceImpl;
import com.haochang.dubbo.util.URL;

/**
 * @description: 描述：服务提供者
 * @author: youzhi.gao
 * @date: 2021-01-28 09:48
 */
public class Provider {

    public static void main(String[] args) {

        try {
            URL url = new URL("localhost", 8080);
            RemoteRegister.regist(HelloService.class.getName(), url);
            LocalRegister.register(HelloService.class.getName(), HelloServiceImpl.class);

            Protocol protocol = ProtocolFactory.getProtocol();
            protocol.start(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
