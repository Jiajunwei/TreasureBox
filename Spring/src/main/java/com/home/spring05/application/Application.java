package com.home.spring05.application;

import com.home.spring05.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Application {

    // 1.通过@Resource注入
    @Resource
    private BookDAO dao1;

    private BookDAO dao2;
    private BookDAO dao3;
    private BookDAO dao4;

    //2.注入给构造方法
    @Autowired
    public Application(BookDAO dao) {
        this.dao2=dao;
    }

    //3.注入给set方法
    @Autowired
    public void setDao3(BookDAO dao) {
        this.dao3 = dao;
    }

    //4.注入给方法参数
    @Autowired
    public void injectDao4(BookDAO dao) {
        this.dao4 = dao;
    }


    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring05/spring-config.xml");
        Application obj = ctx.getBean(Application.class);
        System.out.println(obj.dao1);
        System.out.println(obj.dao2);
        System.out.println(obj.dao3);
        System.out.println(obj.dao4);
    }
}
