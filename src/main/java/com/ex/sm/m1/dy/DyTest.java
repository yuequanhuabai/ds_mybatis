package com.ex.sm.m1.dy;

import java.lang.reflect.Proxy;

public class DyTest {

    public static void main(String[] args) {

        RealService realService = new RealService();

        Service service = (Service)Proxy.newProxyInstance(
                Service.class.getClassLoader(),
                new Class<?>[]{Service.class},
                new ServiceInvocationHandler(realService)
        );

        service.perform();

    }
}
