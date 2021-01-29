package com.haochang.dubbo.util;

import java.io.Serializable;

/**
 * @description: 描述：请求url
 * @author: youzhi.gao
 * @date: 2021-01-28 16:19
 */
public class URL implements Serializable {

    private static final long serialVersionUID = -5788510371218929617L;

    private String hostName;
    private Integer port;

    public URL(String hostName, Integer port) {
        this.hostName = hostName;
        this.port = port;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
