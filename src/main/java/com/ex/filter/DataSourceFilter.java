//package com.ex.filter;
//
//import com.ex.dynamic.DataSourceContextHolder;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//public class DataSourceFilter implements Filter {
//
//
//
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//
//        try {
//            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//            String dsId = httpServletRequest.getParameter("dsId");
//
//            if (dsId != null && !dsId.isEmpty()) {
//                DataSourceContextHolder.setDataSourceType(dsId);
//            } else {
//                DataSourceContextHolder.setDataSourceType("ds1"); // 默认数据源
//            }
//
//            chain.doFilter(request, response);
//        }finally {
//            DataSourceContextHolder.clearDataSourceType();
//        }
//
//    }
//}
