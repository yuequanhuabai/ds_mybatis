package com.ex.sm.m1;

public class TestProxy {
    public static void main(String[] args) {
        Foo foo= (Foo)DebugProxy.newInstance(new FooImpl());
        foo.bar(null);
    }
}
