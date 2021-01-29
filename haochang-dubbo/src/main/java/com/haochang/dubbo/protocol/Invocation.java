package com.haochang.dubbo.protocol;

import java.io.Serializable;

/**
 * @description: 描述：调用信息
 * @author: youzhi.gao
 * @date: 2021-01-28 09:43
 */
public class Invocation implements Serializable {

    private static final long serialVersionUID = -4239799828046899735L;

    public String interfaceName;

    private String methodName;

    private Class[] paramType;

    private Object[] paramValue;

    private String protocol;

    private String version;

    public Invocation() {
    }

    public Invocation(String interfaceName, String methodName, Class[] paramType, Object[] paramValue) {
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.paramType = paramType;
        this.paramValue = paramValue;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getParamType() {
        return paramType;
    }

    public void setParamType(Class[] paramType) {
        this.paramType = paramType;
    }

    public Object[] getParamValue() {
        return paramValue;
    }

    public void setParamValue(Object[] paramValue) {
        this.paramValue = paramValue;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
