package com.home.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class MyServlet implements Servlet {
    //初始化
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init被访问了");
    }

    //servlet配置
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service被访问了");
        servletResponse.getWriter().write("Hello World Servlet!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destory被访问了");
    }
}
