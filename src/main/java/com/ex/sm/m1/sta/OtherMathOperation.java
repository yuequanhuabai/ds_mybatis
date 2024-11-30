package com.ex.sm.m1.sta;

public class OtherMathOperation {


    public int  OtherMathOperation() {
        SimpleMathOperation  simpleMathOperation = new SimpleMathOperation();
        System.out.println("Executing multiply method");
        int result = simpleMathOperation.multiply(3, 5);
        System.out.println("Result: " + result);

        return result;
    }
}
