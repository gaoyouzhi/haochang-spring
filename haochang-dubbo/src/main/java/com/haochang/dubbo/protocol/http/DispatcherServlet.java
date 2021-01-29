package com.haochang.dubbo.protocol.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: 描述：tomcat服务器分发
 * @author: youzhi.gao
 * @date: 2021-01-28 15:05
 */
public class DispatcherServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpServletHandler.handler(req, resp);
    }
}
