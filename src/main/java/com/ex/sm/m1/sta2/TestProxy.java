package com.ex.sm.m1.sta2;

public class TestProxy {
    public static void main(String[] args) {
        RealDataBaseAction action = new RealDataBaseAction();
        DataBaseActionProxy proxy = new DataBaseActionProxy(action);
        proxy.execute();
    }
}
