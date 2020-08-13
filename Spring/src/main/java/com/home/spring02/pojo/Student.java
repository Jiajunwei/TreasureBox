package com.home.spring02.pojo;

public class Student extends Human{


    /**
     * 无参构造函数
     */
    public Student() {
    }

    /**
     * 有参构造函数
     */
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "country='" + id + '\'' +
                ", city='" + name + '\'' +
                '}';
    }


}
