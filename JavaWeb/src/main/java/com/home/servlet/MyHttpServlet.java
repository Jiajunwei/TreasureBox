package com.home.servlet;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class MyHttpServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // test02
        resp.getWriter().write("Hello World HttpServlet!");

        // test03，获取ServletConfig对象，进而获取在web.xml中的参数
        ServletConfig config = this.getServletConfig();
        String name = config.getInitParameter("author_name");
        resp.getWriter().write(name);

        //获取到ServletContext对象，进而获取整个站点的配置参数
        ServletContext context = this.getServletContext();
        String tcl = context.getInitParameter("testName");
        System.out.println(tcl);

        //调用ServletContext方法获取到读取文件的流


        InputStream inputStream = context.getResourceAsStream("1.jpg");
        System.out.println(inputStream);


    }
}
