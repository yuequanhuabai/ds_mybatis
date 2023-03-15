//package com.ex.aspect;
//
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//public class SysTimeAspect {
//
//    @Pointcut("bean(studentServiceImpl)")
//    public void doTime() {
//    }
//
//    @Before("doTime()")
//    public void doBefore(JoinPoint joinPoint) {
//        System.out.println("time doBefore()");
//    }
//
//    @After("doTime()")
//    public void doAfter() {
//        System.out.println("time doAfter()");
//    }
//
//    @AfterReturning("doTime()")
//    public void doAfterReturning() {
//        System.out.println("time doAfterReturning");
//    }
//
//    @AfterThrowing("doTime()")
//    public void doAfterThrowing() {
//        System.out.println("time doAfterThrowing");
//    }
//
//    @Around("doTime()")
//    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        System.out.println("time doAround.before");
//        Object proceed = proceedingJoinPoint.proceed();
//        System.out.println("time doAround.after");
//        return proceed;
//    }
//
//}
