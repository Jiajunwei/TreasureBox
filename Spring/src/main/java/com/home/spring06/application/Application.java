package com.home.spring06.application;

import com.home.spring06.config.ApplicationCfg;
import com.home.spring06.service.BookService;
import com.home.spring06.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        //容器，注解配置应用程序容器，Spring通过反射ApplicationCfg.class初始化容器
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationCfg.class);

        // 1.由方法指定实例，需要在配置类中return一个BookServiceImpl实例，BookServiceImpl上不用再加@Service注解
        BookService bookService=ctx.getBean("getBookService", BookService.class);
        bookService.storeBook("《Spring MVC权威指南 第四版》");

        // 2.由注解指定实例，配置类中无需返回StudentServiceImpl实例，但是StudentServiceImpl上需加@Service注解
        // 配置类中没有返回StudentServiceImpl的实例，但还是能获取到该bean，是因为包扫描能扫描到
        StudentService studentService = ctx.getBean(StudentService.class);
        studentService.showStudent(123);

        // 3.既返回了实例，又加了注解的，在ctx.getBean中不仅要指定type，还要指定名字
        // 比如下面BookServiceImpl类上有@Service注解，并且ApplicationCfg配置类中返回了一个BookServiceImpl实例
        // 如果ctx.getBean中不写bookServiceImpl就会报错
        BookService bookService1 =ctx.getBean("bookServiceImpl", BookService.class);
        bookService1.storeBook("《Java 从入门到精通》");

    }
}
