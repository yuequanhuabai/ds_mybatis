//package com.ex.filter;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfig {
//
//    public FilterRegistrationBean<DataSourceFilter> dataSourceFilterRegisteation(DataSourceFilter filter){
//
//
//        FilterRegistrationBean<DataSourceFilter> registration = new FilterRegistrationBean<>();
//        registration.setFilter(filter);
//        registration.addUrlPatterns("/*");
//        registration.setName("dataSourceFilter");
//        registration.setOrder(0);
//        return registration;
//
//    }
//
//}
