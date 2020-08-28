package com.home.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyHttpServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    // Response
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 一、调用getOutputStream()方法向浏览器输出数据
        // 1.print方法会内容转为二进制数据，转换时的编码不支持中文，所以下面的代码会出问题
        resp.getOutputStream().print("aaa");
        resp.getOutputStream().print("中文测试");

        // 2.下面输出不会有问题，但是输出编码格式为gb2312
        resp.getOutputStream().write("aaa".getBytes());
        resp.getOutputStream().write("中文测试".getBytes());

        // 3.想把它输出为utf-8时，需要同时设置浏览器的编码也为utf-8，否则也会乱码
        resp.getOutputStream().write("aaa".getBytes("utf-8"));
        resp.getOutputStream().write("中文测试".getBytes("utf-8"));

        // 4.为了不每次都去更改浏览器的编码格式，需要告诉浏览器响应数据的编码格式，设置消息头的方式
        resp.setHeader("Content-Type", "text/html;charset=utf-8");
        resp.getOutputStream().write("中文测试".getBytes("utf-8"));

        // 5.另外也可以使用html的标签模拟一个http消息头，告诉浏览器回送数据的编码和格式
        resp.getOutputStream().write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".getBytes());
        resp.getOutputStream().write("中文测试".getBytes("UTF-8"));

        // 二、调用getWriter()方法向浏览器输出数据
        // getWriter()方法是Writer的子类，只能向浏览器输出字符数据，不能输出二进制数据
        // 1.直接输出中文会乱码
        resp.getWriter().write("中文测试");
        // 2.设置一下编码，但是浏览器不一定是utf-8，所以会乱码
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("中文测试");
        // 3.设置浏览器用UTF-8编码显示数据（还可以使用一、中的4.5.）
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("中文测试");

        // 最常用的方法就是下面这个
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("中文测试");
    }
}
