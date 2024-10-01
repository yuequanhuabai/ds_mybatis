//package com.ex.inter;
//
//import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadPoolExecutor;
//
//public class ThreadPoolManager implements ThreadPoolMBean {
//     ThreadPoolExecutor executor;
//
//    public ThreadPoolManager(ThreadPoolExecutor executor) {
//        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
//    }
//
//
//    @Override
//    public int getCorePoolSize() {
//        return executor.getCorePoolSize();
//    }
//
//    @Override
//    public void setCorePoolSize(int corePoolSize) {
//        executor.setCorePoolSize(corePoolSize);
//    }
//
//    @Override
//    public int getMaximumPoolSize() {
//        return executor.getMaximumPoolSize();
//    }
//
//    @Override
//    public void setMaximumPoolSize(int maximumPoolSize) {
//        executor.setMaximumPoolSize(maximumPoolSize);
//    }
//}
