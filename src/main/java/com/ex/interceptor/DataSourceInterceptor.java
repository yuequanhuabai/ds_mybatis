//package com.ex.interceptor;
//
//import com.ex.dynamic.DataSourceContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class DataSourceInterceptor implements HandlerInterceptor {
//
//    private static final String DS_ID_PARAM = "dsId"; // 前端传递的参数名称
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//
//        return true;
//    }
//
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        DataSourceContextHolder.clearDataSourceType();
//    }
//}
