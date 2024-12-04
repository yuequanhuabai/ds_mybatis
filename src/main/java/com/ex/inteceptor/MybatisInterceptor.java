package com.ex.inteceptor;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;

import java.lang.reflect.Method;
import java.util.Properties;


//@Intercepts({
//        @Signature(type = Executor.class,method = )
//})
public class MybatisInterceptor implements Interceptor {

    private Integer defaultLimit;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        Method method = invocation.getMethod();
        Object target = invocation.getTarget();
        Class<? extends Invocation> aClass = invocation.getClass();
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
