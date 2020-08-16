package com.home.spring01.application;

import com.home.spring01.service.impl.BookServiceImpl;
import com.home.spring01.service.impl.StudentServiceImpl;

public class Application {

    public static void main(String[] args) {
        test01();
        test02();
    }

    // 使用XML配置的方式实现IOC
    private static void test01(){
        BookServiceImpl bookService=new BookServiceImpl();
        bookService.storeBook("《Spring MVC权威指南 第一版》");
    }

    // 使用XML配置的方式实现IOC
    private static void test02(){
        StudentServiceImpl studentService =  new StudentServiceImpl();
        String student = studentService.getStudent(1);
        System.out.println(student);
    }
}
