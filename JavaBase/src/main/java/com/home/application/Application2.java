package com.home.application;

import com.home.annotation.MyAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 注解
 */
public class Application2 {

    public static void main(String[] args) throws Exception {
        Class<Demo> demoClass = Demo.class;
        MyAnnotation annotationOnClass = demoClass.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnClass.getValue());

        Method method = demoClass.getMethod("hello");
        MyAnnotation annotationOnMethod = method.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnMethod.getValue());

        Field field = demoClass.getField("name");
        MyAnnotation annotationOnFiled = field.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnFiled.getValue());

        Method defaultMethod = demoClass.getMethod("defaultMethod");
        MyAnnotation annotationOnDefaultMethod = defaultMethod.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnDefaultMethod.getValue());

    }
}
