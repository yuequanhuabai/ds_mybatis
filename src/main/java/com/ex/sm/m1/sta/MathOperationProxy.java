package com.ex.sm.m1.sta;

public class MathOperationProxy implements MathOperation{

    private MathOperation mathOperation;

    public MathOperationProxy(MathOperation mathOperation) {
        this.mathOperation = mathOperation;
    }



    @Override
    public int multiply(int a, int b) {

        System.out.println("Executing multiply method");
        int result = mathOperation.multiply(a, b);
        System.out.println("Result: " + result);
        return result;
    }
}
