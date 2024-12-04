package com.ex.sm.m1.cglib2;

import net.sf.cglib.proxy.Enhancer;

public class TestCglib {
    public static void main(String[] args) {
        RealService realService = new RealService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(realService.getClass());
        enhancer.setCallback(new CglibProxy(realService));
        RealService proxyInstance = (RealService) enhancer.create();
//        System.out.println("Calling proxyInstance.doSomething...");
        proxyInstance.doSomething();

    }
}
