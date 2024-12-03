package com.ex.sm.m1.dy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyService implements InvocationHandler {

    private Object target;

    public ProxyService(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before doSomething...");
        Object result = method.invoke(target, args);
        System.out.println("after doSomething...");
        return result;
    }

}
