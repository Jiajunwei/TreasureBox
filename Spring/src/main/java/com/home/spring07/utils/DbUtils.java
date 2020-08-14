package com.home.spring07.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class DbUtils {

    @Value("${db.driver}")
    private String driver;
    @Value("${db.url}")
    private String location;
    @Value("${db.username}")
    private String usr;
    @Value("${db.password}")
    private String pwd;

    @Override
    public String toString() {
        return "DbUtils{" +
                "driver='" + driver + '\'' +
                ", location='" + location + '\'' +
                ", usr='" + usr + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
