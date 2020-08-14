package com.home.spring06.service.impl;

import com.home.spring06.dao.StudentDao;
import com.home.spring06.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    public void showStudent(int id) {
        String student = studentDao.getStudent(id);
        System.out.println(student + " is showing");
    }
}
