package com.home.spring04.application;

import com.home.spring04.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class Application {

    @Autowired // 默认是按照类型装配注入的，如果想按照名称来转配注入，则需要结合@Qualifier一起使用
    @Qualifier("impl") //BookDao有两个实现类BookDaoImpl和BookDaoImpl2，如果不加@Qualifier会出现混乱
    BookDao bookDao;

//    还可以使用@Resource
//    @Resource(name = "bookDaoImpl") // 使用@Resource注入，根据默认类名区分
//    @Resource(name = "impl") // 使用@Resource注入，根据@Service指定的名称区分
//    BookDao bookDao;

    // 使用Spring注解配置IOC（Application类）
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring04/spring-config.xml");
        Application obj = ctx.getBean(Application.class);
        System.out.println(obj.bookDao);
    }
}
