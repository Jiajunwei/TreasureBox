package com.home.spring_09_mybatis.mapper.impl;

import com.home.spring_09_mybatis.entities.BookType;
import com.home.spring_09_mybatis.mapper.BookTypeDAO;
import com.home.spring_09_mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookTypeDAOImpl implements BookTypeDAO {
    public List<BookType> getAllBookTypes() {
        //获得会话对象
        SqlSession session= MyBatisUtil.getSession();
        try {
            //通过MyBatis实现接口BookTypeDAO，返回实例
            BookTypeDAO bookTypeDAO=session.getMapper(BookTypeDAO.class);
            return bookTypeDAO.getAllBookTypes();
        } finally {
            session.close();
        }
    }
}
