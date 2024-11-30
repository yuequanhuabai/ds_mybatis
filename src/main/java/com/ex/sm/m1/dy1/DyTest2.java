package com.ex.sm.m1.dy1;

public class DyTest2 {

    public static void main(String[] args) {

        // 實際要代理的對象
        DyService dyService = new DyServiceImpl();
        Class<?>[] interfaces = dyService.getClass().getInterfaces();

        // 代理實例要實現的接口列表；
        DyService proxy = ProxyFactory.createProxy(
                dyService,interfaces
        );

        proxy.dy();

//        ProxyFactory.createProxy(dyService,interfaces);

    }
}
