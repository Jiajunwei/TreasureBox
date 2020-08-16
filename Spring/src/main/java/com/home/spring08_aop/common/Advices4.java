package com.home.spring08_aop.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Advices4 {

    // 切入点为MyUser的所有方法
    @Pointcut("execution(* com.home.spring08_aop.common.MyUser.*(..))")
    public void pointcut(){
    }

    @Before("pointcut()") // 切点复用
    public void before(JoinPoint jp){
        System.out.println("----------无XML实现Spring IOC和AOP：前置通知----------");
        System.out.println(jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName());
    }
}
