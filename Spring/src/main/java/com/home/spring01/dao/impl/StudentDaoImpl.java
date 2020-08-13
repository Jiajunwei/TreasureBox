package com.home.spring01.dao.impl;

import com.home.spring01.dao.StudentDao;

public class StudentDaoImpl implements StudentDao {

    public String getStudent(int id) {
        return "学生" + id;
    }
}
