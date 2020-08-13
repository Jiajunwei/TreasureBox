package com.home.spring02.application;

import com.home.spring02.pojo.Student;
import com.home.spring02.pojo.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring02/spring-config.xml");
        // 两种方法获取Student对象，其中s1是无参构造方法创建的对象，s2是有参构造方法创建的对象
        Student s1 = (Student) ctx.getBean("s1");
        Student s2 = ctx.getBean("s2", Student.class);
//        Student s3 = ctx.getBean(Student.class);
        System.out.println(s1);
        System.out.println(s2);
//        System.out.println(s3);

        // 通过构造方法创建对象，通过属性进行赋值
        Teacher t1 = ctx.getBean("t1", Teacher.class);
        System.out.println(t1);

        // 从容器中取回的对象默认是单例的，因此t11与t1相等
        Teacher t11 = ctx.getBean("t1", Teacher.class);
        System.out.println(t1.equals(t11));
        System.out.println(t1 == t11);

    }
}
