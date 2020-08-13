package com.home.spring01.service.impl;

import com.home.spring01.dao.BookDAO;
import com.home.spring01.dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentServiceImpl implements StudentDao {

    private StudentDao studentDao;

    public StudentServiceImpl(){
        //容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring01/spring-config.xml");
        //从容器中获得id为studentDao的bean
        studentDao = (StudentDao)ctx.getBean("studentDao");
    }


    public String getStudent(int id) {
        String student = studentDao.getStudent(1);
        return student;
    }
}
