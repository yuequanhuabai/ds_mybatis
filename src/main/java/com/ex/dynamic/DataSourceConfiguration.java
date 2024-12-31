package com.ex.dynamic;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class DataSourceConfiguration {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;


    @Bean
    public MyRoutingDataSource myRoutingDataSource() {
        MyRoutingDataSource myRoutingDataSource = new MyRoutingDataSource();

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        myRoutingDataSource.setDefaultTargetDataSource(druidDataSource);

//        Map<Object, Object> targetDataSources = new HashMap<>();
//        targetDataSources.put("ds1", druidDataSource);
        myRoutingDataSource.setTargetDataSources(new HashMap<>());
        return myRoutingDataSource;
    }

}
