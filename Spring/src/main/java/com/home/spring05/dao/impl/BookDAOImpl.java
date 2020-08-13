package com.home.spring05.dao.impl;


import com.home.spring05.dao.BookDAO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope("prototype")
@Repository
public class BookDAOImpl implements BookDAO {

    public String addBook(String bookName) {
        return "添加图书"+bookName+"成功！";
    }

}
