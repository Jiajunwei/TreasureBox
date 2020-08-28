package com.home.application;

import com.home.annotation.MyAnnotaion;

import java.lang.reflect.Field;

public class Application {

    public static void main(String[] args) throws NoSuchFieldException {
        // 获取类上注解
        Class<Demo> demoClass = Demo.class;
//        MyAnnotaion annotationOnClass = demoClass.getAnnotation(MyAnnotaion.class);
//        System.out.println(annotationOnClass);

        // 获取成员变量注解
//        Field name = demoClass.getField("name");
        Field[] fields = demoClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }
}
