package com.home.spring08_aop.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 通知类，横切逻辑
 */
@Component
@Aspect
public class Advices3 {

    // 切入点为StrUtil的所有方法
    @Pointcut("execution(* com.home.spring08_aop.common.StrUtil.*(..))")
    public void pointcut(){
    }

    @Before("pointcut()") // 切点复用
    public void before(JoinPoint jp){
        System.out.println("----------切点复用：前置通知----------");
        System.out.println(jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName());
    }

    @After("pointcut()") // 切点复用
    public void after(JoinPoint jp){
        System.out.println("----------切点复用：最终通知----------");
    }
}
