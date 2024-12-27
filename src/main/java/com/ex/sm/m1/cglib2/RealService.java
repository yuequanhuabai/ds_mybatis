package com.ex.sm.m1.cglib2;

public class RealService {

    public void doSomething() {
        System.out.println("Executing doSomething");
//       RealService proxy = (RealService)ProxyFactory.getProxy();
        doSomething2();
    }

    private void doSomething2() {
        System.out.println("Executing doSomething2...");
    }

}
