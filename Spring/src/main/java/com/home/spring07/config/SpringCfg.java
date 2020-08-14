package com.home.spring07.config;

import com.home.spring07.utils.DbUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("spring07/db.properties")
public class SpringCfg {

    @Bean
    public DbUtils getDbUtils(){
        return new DbUtils();
    }
}
