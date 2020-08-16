package com.home.spring08_aop.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect  // 添加注解使其成为切面
public class Advices2 {
    @Before("execution(* com.home.spring08_aop.common.MyMath2.*(..))") //切入点为MyMath2的所有方法
    public void before(JoinPoint jp){                                  //在切入点的方法调用之前（之后、环绕等）执行指定的方法，从而进行增强处理
        System.out.println("----------前置通知----------");
        System.out.println(jp.getSignature().getName());
    }

    @After("execution(* com.home.spring08_aop.common.MyMath2.*(..))")
    public void after(JoinPoint jp){
        System.out.println("----------最终通知----------");
    }

    //execution切点函数
//    //com.home.spring08_aop.common2包下所有类的所有方法被切入
//    @After("execution(* com.home.spring08_aop.common.*.*(..))")
//    public void after(JoinPoint jp){
//        System.out.println("----------切点函数测试：最终通知----------");
//    }

//    //within切点函数
//    //com.home.spring08_aop.common2包下所有类的所有方法被切入
//    @After("within(com.home.spring08_aop.common.*)")
//    public void after(JoinPoint jp){
//        System.out.println("----------最终通知----------");
//    }

//    //this切点函数
//    //实现了IMath接口的代理对象的任意连接点
//    @After("this(com.home.spring08_aop.common.IMath)")
//    public void after(JoinPoint jp){
//        System.out.println("----------最终通知----------");
//    }

//    //args切点函数
//    //要求方法有两个int类型的参考才会被织入横切逻辑
//    @After("args(int,int)")
//    public void after(JoinPoint jp){
//        System.out.println("----------最终通知----------");
//    }

//    //@annotation切点函数
//    //要求方法必须被注解com.home.spring08_aop.common.MyAnno才会被织入横切逻辑
//    @After("@annotation(com.home.spring08_aop.common.MyAnno)")
//    public void after(JoinPoint jp){
//        System.out.println("----------最终通知----------");
//    }
}
