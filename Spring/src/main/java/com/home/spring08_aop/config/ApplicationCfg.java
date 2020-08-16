package com.home.spring08_aop.config;

import com.home.spring08_aop.common.MyUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration  //用于表示当前类为容器的配置类，类似<beans/>
@ComponentScan(basePackages="com.home.spring08_aop.common")  //扫描的范围，相当于xml配置的结点<context:component-scan/>
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ApplicationCfg {
    @Bean
    public MyUser getUser(){
        return new MyUser();
    }
}
