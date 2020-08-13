package com.home.spring03.dao.impl;


import com.home.spring03.dao.BookDAO;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


//@Scope("prototype")
//@Lazy
@Repository // 默认名为bookDAOImpl
public class BookDAOImpl implements BookDAO {

    public String addBook(String bookName) {
        return "添加图书"+bookName+"成功！";
    }

    @PostConstruct
    public void init(){
        System.out.println("BookDAOImpl初创建完成了");
    }

    @PreDestroy
    public void destory(){
        System.out.println("BookDAOImpl准备销毁了");
    }

}
