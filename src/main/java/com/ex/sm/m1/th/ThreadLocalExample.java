package com.ex.sm.m1.th;

public class ThreadLocalExample {

    private static   ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);


    public static void main(String[] args) {

        Runnable task = () -> {
            Integer currentValue = threadLocal.get();

            currentValue++;
            threadLocal.set(currentValue);
            System.out.println("ThreadLocal:  " + Thread.currentThread().getName() +"   ||  value: "+threadLocal.get());

        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

    }
}
