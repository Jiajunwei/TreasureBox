package com.home.spring04.dao.impl;

import com.home.spring04.dao.BookDao;
import org.springframework.stereotype.Repository;

@Repository("impl2")
public class BookDaoImpl2 implements BookDao {
    public String addBook(String bookName) {
        return "添加图书"+bookName+"成功！";
    }
}
