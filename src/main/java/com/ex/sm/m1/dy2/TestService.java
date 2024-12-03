package com.ex.sm.m1.dy2;

import java.lang.reflect.Proxy;

public class TestService {

    public static void main(String[] args) {

        RealService realService = new RealService();

        Service service = (Service) Proxy.newProxyInstance(
                realService.getClass().getClassLoader(),
                realService.getClass().getInterfaces(),
                new ProxyService(realService)
        );

        service.doSomething();

    }

}
