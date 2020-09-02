package com.home.annotation;

import com.home.application.Demo;
import com.home.enumType.CityEnum;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String getValue() default "no description";

    // 八种基本数据类型
    byte btyeValue() default 1;
    short shortValue() default 0;
    int intValue() default 11;
    long longValue() default 0L;
    float floatValue() default 0;
    double doubleValue() default 0;
    char charVaule() default 'c';
    boolean booleanVaule() default true;

    // 其他一些类型
    String name() default "name";
    CityEnum cityName() default CityEnum.HangZhou;
    Class className() default Demo.class;
    MyAnnotation2 annotation2() default @MyAnnotation2;

    //以上几种的一维数组
    int[] intValueArray() default {1,2};
    String[] names() default {"ok", "fine"};


}
