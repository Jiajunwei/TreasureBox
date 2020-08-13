package com.home.spring01.service.impl;

import com.home.spring01.dao.BookDAO;
import com.home.spring01.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    // 初始化时BookDao
    public BookServiceImpl() {
        //容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring01/spring-config.xml");
        //从容器中获得id为bookdao的bean
        bookDAO=(BookDAO)ctx.getBean("bookdao");
    }


    public void storeBook(String bookname){
        System.out.println("图书上货");
        String result=bookDAO.addBook(bookname);
        System.out.println(result);
    }
}
