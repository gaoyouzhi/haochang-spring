package com.haochang.dubbo.protocol;


import com.haochang.dubbo.util.URL;

/**
 * @ClassName: Protocol
 * @Description 协议实体
 * @Author: youzhi.gao
 * @Date: 2021-01-28 14:48
 * @Version 1.0.0
 */
public interface Protocol {

    String send(URL url, Invocation invocation);

    void start(URL url);
}
