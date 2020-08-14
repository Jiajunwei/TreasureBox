package com.home.spring06.dao.impl;

import com.home.spring06.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {

    public String getStudent(int id) {
        return "student"+id;
    }
}
