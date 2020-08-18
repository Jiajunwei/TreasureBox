package com.home.spring_09_mybatis.mapper;

import com.home.spring_09_mybatis.entities.BookType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookTypeDAO {
    /*
     * 获得所有图书类型
     */
    public List<BookType> getAllBookTypes();
}
