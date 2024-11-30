package com.ex.sm.m1.dy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceInvocationHandler implements InvocationHandler {

   private final Service service;

    public ServiceInvocationHandler(Service service) {
        this.service = service;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke method");
        Object result = method.invoke(service, args);
        System.out.println("After invoke method");
        return result;
    }


}
