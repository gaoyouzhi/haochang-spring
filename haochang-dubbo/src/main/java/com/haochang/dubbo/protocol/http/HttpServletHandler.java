package com.haochang.dubbo.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.haochang.dubbo.regist.LocalRegister;
import com.haochang.dubbo.protocol.Invocation;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description: 描述：请求处理
 * @author: youzhi.gao
 * @date: 2021-01-28 15:07
 */
public class HttpServletHandler {

    public static void handler(HttpServletRequest req, HttpServletResponse resp) {
        try {
//            Invocation invocation = JSONObject.parseObject(req.getInputStream(), Invocation.class);

            ObjectInputStream ois = new ObjectInputStream(req.getInputStream());
            Invocation invocation = (Invocation)ois.readObject();
            String interfaceName = invocation.getInterfaceName();
            String methodName = invocation.getMethodName();
            Class[] paramType = invocation.getParamType();
            Object[] param = invocation.getParamValue();

            Class clazz = LocalRegister.get(interfaceName);
            Method method = clazz.getMethod(methodName, paramType);
            String result = (String) method.invoke(clazz.newInstance(), param);

            System.out.println("tomcat:" + result);
            IOUtils.write(result, resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
