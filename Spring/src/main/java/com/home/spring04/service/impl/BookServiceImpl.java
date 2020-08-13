package com.home.spring04.service.impl;

import com.home.spring04.dao.BookDao;
import com.home.spring04.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    @Qualifier("impl")
    BookDao bookDao;

    public void storeBook(String bookName) {
        System.out.println("图书上货");
        String result=bookDao.addBook(bookName);
        System.out.println(result);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring04/spring-config.xml");
        BookServiceImpl bookServiceImpl =ctx.getBean(BookServiceImpl.class);
        bookServiceImpl.storeBook("Java从入门到精通");
    }


}
