package com.home.application;

import com.home.annotation.MyAnnotation;

@MyAnnotation(getValue = "annotation on class")
public class Demo {

    @MyAnnotation(getValue = "annotation on field")
    public String name; // public不可省略

    @MyAnnotation(getValue = "annotation on method")
    public void hello(){}

    @MyAnnotation()
    public void defaultMethod(){}


}
