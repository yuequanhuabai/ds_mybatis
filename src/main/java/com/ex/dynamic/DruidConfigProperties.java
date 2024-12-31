//package com.ex.dynamic;
//
//
//import com.alibaba.druid.pool.DruidDataSource;
//import lombok.Data;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//@Data
//@Configuration
//@Component
//@ConfigurationProperties("sring.data.druid")
//public class DruidConfigProperties {
//
//    private Integer initialSize;
//    private Integer minIdle;
//    private Integer maxActive;
//    private Integer maxWait;
//    private Boolean testWhileIdle;
//    private Integer timeBetweenEvictionRunsMillis;
//
////    private String validationQuery;
////    private String validationQueryTimeout;
////    private String url;
////    private String url;
////    private String url;
////    private String url;
////    private String url;
////    private String url;
////    private String url;
////    private String url;
////    private String url;
////    private String url;
//
//
//    public void copyProperty(DruidDataSource dataSource){
//        dataSource.setInitialSize(initialSize);
//        dataSource.setMinIdle(minIdle);
//        dataSource.setMaxActive(maxActive);
//        dataSource.setMaxWait(maxWait);
//        dataSource.setTestWhileIdle(testWhileIdle);
//        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//
//    }
//
//}
