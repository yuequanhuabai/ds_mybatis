package com.ex.sm.m1.cglib2;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    private Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("Before invoke " + method.getName());

//        Object invoke = method.invoke(target, objects);
        if (2 == method.getModifiers()) {
            method.setAccessible(true);
        }

//         methodProxy.getSignature();

//        ProcessJoinPoint processJoinPoint = new ProcessJoinPoint();


        Object invoke = methodProxy.invokeSuper(o, objects);

//        Object invoke=  method.invoke(target, objects);

        System.out.println("After invoke " + method.getName());

        return invoke;
    }
}
