package com.ex.sm.m1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DebugProxy implements InvocationHandler {

    private Object obj;

    private DebugProxy(Object obj) {
        this.obj = obj;
    }

    public static Object newInstance(Object obj) {
        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new DebugProxy(obj));
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;

        try {
            System.out.println("before method: " + method.getName());
            result = method.invoke(obj, args);
        }catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("after method: " + method.getName());
        }



        return result;
    }
}
