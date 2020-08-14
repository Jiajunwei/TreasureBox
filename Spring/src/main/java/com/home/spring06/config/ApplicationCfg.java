package com.home.spring06.config;

import com.home.spring06.service.BookService;
import com.home.spring06.service.impl.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.home.spring06") // 不添加包扫描注解的话只能获取到返回的bean，
public class ApplicationCfg {

    @Bean // @Bean不写值的话bean的Name就是函数名
    public BookService getBookService(){
        return new BookServiceImpl();
    }
}
