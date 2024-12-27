package com.ex.sm.m1.cglib1;

import net.sf.cglib.proxy.Enhancer;

public class TestCglib {
    public static void main(String[] args) {
        RealService1 realService1 = new RealService1();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(realService1.getClass());
        enhancer.setCallback(new CglibProxy(realService1));
        RealService1 proxyInstance = (RealService1) enhancer.create();
        proxyInstance.doSomething2();
    }
}
