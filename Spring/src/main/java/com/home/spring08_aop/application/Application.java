package com.home.spring08_aop.application;

import com.home.spring08_aop.common.MyMath;
import com.home.spring08_aop.common.MyUser;
import com.home.spring08_aop.common.StrUtil;
import com.home.spring08_aop.common.MyMath2;
import com.home.spring08_aop.config.ApplicationCfg;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

//        test01();
//        test02();
//        test03();
//        test04();
        test05();
    }

    // 基于XML配置的Spring AOP
    private static void test01(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring08_aop/spring-config.xml");
        MyMath math = ctx.getBean("math", MyMath.class);
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }

    // 使用注解配置AOP
    private static void test02(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring08_aop/spring-config2.xml");
        MyMath2 math = ctx.getBean("math2", MyMath2.class);
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }

    // 测试:AspectJ切点函数（用来描述切入点详细位置的函数）
    private static void test03(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring08_aop/spring-config2.xml");
        StrUtil strUtil=ctx.getBean("strUtil",StrUtil.class);
        strUtil.show();
    }

    // 测试:切点复用
    private static void test04(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring08_aop/spring-config2.xml");
        StrUtil strUtil=ctx.getBean("strUtil",StrUtil.class);
        strUtil.show();
    }

    // 测试：零配置实现Spring IoC与AOP
    private static void test05(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationCfg.class);
        MyUser myUser=ctx.getBean(MyUser.class);
        myUser.show();
    }
}
