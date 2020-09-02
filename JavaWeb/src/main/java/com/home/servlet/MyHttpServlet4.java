package com.home.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyHttpServlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取到网页是从哪里来的，只有通过链接访问当前页的时候才能获取上一页的地址
        String referer = req.getHeader("Referer");

        // 判断是否是从地址栏或者从我的首页来的，如果都不是跳到首页
        if (referer == null || !referer.contains("http://localhost:8080/JavaWeb/index.jsp")){
            // 回到首页去
            resp.sendRedirect("/JavaWeb/index.jsp");
            return;
        }

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("路飞做了XXXXxxxxxxxxxxxxxxxx");
    }
}
