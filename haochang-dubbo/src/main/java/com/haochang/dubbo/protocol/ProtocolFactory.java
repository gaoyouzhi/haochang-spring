package com.haochang.dubbo.protocol;

import com.haochang.dubbo.protocol.dubbo.DubboProtocol;
import com.haochang.dubbo.protocol.http.HttpProtocol;
import org.springframework.util.StringUtils;


/**
 * @description: 描述：协议工厂类
 * @author: youzhi.gao
 * @date: 2021-01-28 16:00
 */
public class ProtocolFactory {

    public static Protocol getProtocol(){
        String protocolName = System.getProperty("protocolName");
        if(!StringUtils.isEmpty(protocolName)){
            switch (protocolName) {
                case "http":
                    return new HttpProtocol();
                case "netty" :
                    return new DubboProtocol();
                default:
                    break;
            }
        }


        return new HttpProtocol();
    }
}
