package com.home.application;

import com.home.annotation.MyAnnotation;

@MyAnnotation(getValue = "annotaion on class")
public class Demo {

    @MyAnnotation(getValue = "annotaion on field")
    String name;

    @MyAnnotation(getValue = "an")
    void hello(){}


}
