package com.ex.sm.m1.dy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxyHandler implements InvocationHandler {

    private Object target;

    public MyProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method invoke");
        Object invoke = method.invoke(target, args);
        System.out.println("after method invoke");
        return invoke;
    }
}
