package com.home.spring06.config;

import com.home.spring06.service.BookService;
import com.home.spring06.service.impl.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.home.spring06")
public class ApplicationCfg {

    @Bean
    public BookService getBookService(){
        return new BookServiceImpl();
    }
}
