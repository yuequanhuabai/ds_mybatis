//package com.ex.conf;
//
//import com.ex.interceptor.MbInterceptor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//
//@Slf4j
//@Configuration
//public class MyBatisInterceptorConfig {
//
//    @Order(1)
//    @Bean
//    public String mbInterceptor(SqlSessionFactory sqlSessionFactory) {
//
//        log.info("into add interceptor ....");
//        sqlSessionFactory.getConfiguration().addInterceptor(new MbInterceptor());
//        return "interceptor";
//    }
//}
