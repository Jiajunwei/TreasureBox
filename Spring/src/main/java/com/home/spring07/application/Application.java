package com.home.spring07.application;

import com.home.spring07.config.SpringCfg;
import com.home.spring07.utils.DbUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        test01();
        test02();
    }


    // test01：通过@Value引用资源文件中的内容
    private static void test01(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring07/spring-config.xml");
        DbUtils db = ctx.getBean(DbUtils.class);
        System.out.println(db);
    }

    // test02：通过@Value引用资源文件中的内容
    // 在SpringCfg类上加注解@PropertySource
    private static void test02(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringCfg.class);
        DbUtils db = ctx.getBean(DbUtils.class);
        System.out.println(db);
    }


}
