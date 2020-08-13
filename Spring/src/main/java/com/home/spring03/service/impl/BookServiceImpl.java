package com.home.spring03.service.impl;

import com.home.spring03.dao.BookDAO;
import com.home.spring03.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;


    public void storeBook(String bookName){

        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring03/spring-config.xml");
        bookDAO = ctx.getBean("bookDAOImpl", BookDAO.class);

        System.out.println("图书上货");
        String result=bookDAO.addBook(bookName);
        System.out.println(result);
    }


}
