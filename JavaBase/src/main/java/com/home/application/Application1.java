package com.home.application;

import com.home.pojo.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 */
public class Application1 {
    public static void main(String[] args) {
        test01();
        test02();
    }

    /**
     * 一、获取Class对象的几种方式
     */
    public static void test01(){
        // 方式一
        Demo demo = new Demo();
        Class demoClass1 = demo.getClass();
        System.out.println(demoClass1.getName());

        // 方式二
        Class demoClass2 = Demo.class;
        System.out.println(demoClass2.getName());
        System.out.println(demoClass2 == demoClass1);// true

        // 方式三（常用）
        try {
            Class demoClass3 = Class.forName("com.home.application.Demo");
            System.out.println(demoClass3.getName());
            System.out.println(demoClass3 == demoClass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 二、反射怎么用
     * 1.用上面的方式获取Class对象 Class demoClass = Class.forName("com.home.application.Demo");
     * 2.获取构造器对象 Constructor con = demoClass.getConstructor(形参类型.class);
     * 3.获取对象 Demo demo =con.newInstance(实参);
     */
    public static void test02(){
        try {
            Class stuClass = Class.forName("com.home.pojo.Student");
            // stuClass.newInstance(); //只能够调用无参的构造函数，即默认的构造函数；
            Constructor constructor = stuClass.getConstructor();//构造方法不同时，获取构造器对象的方法略有不同
            Student student = (Student) constructor.newInstance();
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 三、获取成员变量并使用
     */
    public static void test03(){
        Student student = new Student();
        student.setName("zhangsan");

        try {
            Class stuClass = Class.forName("com.home.pojo.Student");
            // Field stuName = stuClass.getField("name"); // 注意与下面方法的区别
            Field stuName = stuClass.getDeclaredField("name");
            stuName.set(student, "lisi"); // 注意这里的student是对象，不是类对象
            System.out.println(student.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 四、 获取成员方法并使用
     */
    public static void test04(){
        Student student = new Student();
        try {
            Class stuClass = Class.forName("com.home.pojo.Student");
            Method setName = stuClass.getMethod("setName", String.class);
            setName.invoke(student, "wangwu");
            System.out.println(student.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
