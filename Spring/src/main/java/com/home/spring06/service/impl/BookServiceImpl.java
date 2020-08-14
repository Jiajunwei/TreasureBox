package com.home.spring06.service.impl;

import com.home.spring06.dao.BookDAO;
import com.home.spring06.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    BookDAO bookDAO;

    public void storeBook(String bookName) {
        System.out.println("图书上货");
        String result=bookDAO.addBook(bookName);
        System.out.println(result);
    }
}
