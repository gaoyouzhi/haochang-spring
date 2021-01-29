package com.haochang.dubbo.protocol.http;

import com.haochang.dubbo.protocol.Invocation;
import com.haochang.dubbo.protocol.Protocol;
import com.haochang.dubbo.util.HttpClient;
import com.haochang.dubbo.util.URL;


/**
 * @description: 描述：http协议
 * @author: youzhi.gao
 * @date: 2021-01-28 14:49
 */
public class HttpProtocol implements Protocol {

    @Override
    public String send(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url.getHostName(), url.getPort(), invocation);
    }

    @Override
    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getHostName(), url.getPort());
    }
}
