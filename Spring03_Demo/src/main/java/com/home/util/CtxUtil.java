package com.home.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component // 添加注解，注册CtxUtil为Spring Bean，Spring会自动执行setApplicationContext方法
public class CtxUtil implements ApplicationContextAware {
    public static ApplicationContext ctx;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx=applicationContext;
    }
    /**
     * 根据类型获得bean
     */
    public static <T> T getBean(Class<T> clazz){
        return ctx.getBean(clazz);
    }
    /**
     * 根据名称名称获得bean
     */
    public static Object getBean(String name){
        return ctx.getBean(name);
    }
}
