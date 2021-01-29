package com.haochang.dubbo.protocol.dubbo;

import com.haochang.dubbo.protocol.Invocation;
import com.haochang.dubbo.protocol.Protocol;
import com.haochang.dubbo.protocol.http.HttpServer;
import com.haochang.dubbo.util.URL;
import org.apache.http.client.methods.HttpGet;


/**
 * @description: 描述：实现dubbo协议
 * @author: youzhi.gao
 * @date: 2021-01-28 16:02
 */
public class DubboProtocol implements Protocol {
    @Override
    public String send(URL url, Invocation invocation) {

        return null;
    }

    @Override
    public void start(URL url) {

    }
}
