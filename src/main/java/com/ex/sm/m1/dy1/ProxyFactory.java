package com.ex.sm.m1.dy1;

import java.lang.reflect.Proxy;

public class ProxyFactory {


    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target,Class<?>[] interfaces) {

        MyProxyHandler myProxyHandler = new MyProxyHandler(target);

        // 創建代理對象；
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                interfaces,
                myProxyHandler
        );

    }


//    @SuppressWarnings("unchecked")
//    public static <T> T createProxy(T target, Class<?>[] interfaces) {
//        // 创建 InvocationHandler
//        InvocationHandler handler = new MyProxyHandler(target);
//
//        // 创建代理对象
//        return (T) Proxy.newProxyInstance(
//                target.getClass().getClassLoader(),
//                interfaces,
//                handler
//        );
//    }


}
