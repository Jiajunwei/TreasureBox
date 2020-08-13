package com.home.spring01.dao.impl;


import com.home.spring01.dao.BookDAO;

public class BookDAOImpl implements BookDAO {

    public String addBook(String bookName) {
        return "添加图书"+bookName+"成功！";
    }
}
