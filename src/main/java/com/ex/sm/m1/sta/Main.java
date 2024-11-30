package com.ex.sm.m1.sta;

public class Main {

    public static void main(String[] args) {
        SimpleMathOperation realOperation  = new SimpleMathOperation();

        MathOperationProxy proxy = new MathOperationProxy(realOperation );

        int result = proxy.multiply(5, 3);



        SimpleMathOperation realOperation2  = new SimpleMathOperation();

        int multiply = realOperation2.multiply(5, 3);


    }
}
