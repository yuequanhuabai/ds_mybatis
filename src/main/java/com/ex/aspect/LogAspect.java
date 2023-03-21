package com.ex.aspect;

import com.ex.annotation.AopAnnotation;
import com.ex.dao.SysLogsDao;
import com.ex.entity.SysLogs;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@Order(2)
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("bean(studentServiceImpl)")
    public void logPointCut() {
    }

    @Pointcut("@annotation(com.ex.annotation.AopAnnotation)")
    public void logPointCut2() {
    }

    @Resource
    private SysLogsDao sysLogsDao;


    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object proceed = null;
        try {
            long start = System.currentTimeMillis();
            proceed = joinPoint.proceed();
            long end = System.currentTimeMillis();

            queryStu(joinPoint, (end - start));

        } catch (Throwable throwable) {
            log.error(throwable.getMessage());
            throwable.printStackTrace();
        }

        return proceed;
    }



    public void queryStu(ProceedingJoinPoint proceedingJoinPoint, long time) throws JsonProcessingException, NoSuchMethodException {

        Class<?> aClass = proceedingJoinPoint.getTarget().getClass();
        String name = aClass.getName();
        System.out.println("target.class.name: "+name);

        MethodSignature  methodSignature11 = (MethodSignature)proceedingJoinPoint.getSignature();
        Method method1 = methodSignature11.getMethod();
        String name3 = method1.getName();

        Method method2 = aClass.getMethod(methodSignature11.getName(), methodSignature11.getParameterTypes());


        System.out.println("");
        System.out.println("methodSignature11.method1.name3: "+name3);

        Object[] args = proceedingJoinPoint.getArgs();

        Object target = proceedingJoinPoint.getTarget();
        Class<?> targetClass = target.getClass();


        String params = new ObjectMapper().writeValueAsString(args);
        System.out.println("args : " + Arrays.toString(args));

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();


        Method method = getMethod(targetClass, methodSignature);

        Class<? extends Method> aClass1 = method.getClass();
        String s1 = aClass1.toString();
        String name2 = method.getDeclaringClass().getName();


        String name1 = method.getName();

        AopAnnotation annotation = method.getAnnotation(AopAnnotation.class);
        String operation = annotation.value();


        SysLogs sysLogs = new SysLogs();

        sysLogs.setCreateTime(new Date());
        sysLogs.setParams(params);
        sysLogs.setTime(time);
        sysLogs.setIp("192.168.1.1");
        sysLogs.setMethod(name2 + "." + name1);
        sysLogs.setUsername("zhangsan" + Math.random());
        sysLogs.setOperation(operation);
        sysLogs.setId(UUID.randomUUID().toString().replaceAll("-",""));
        sysLogsDao.inertSysLogs(sysLogs);

    }

    private Method getMethod(Class<?> targetClass, MethodSignature methodSignature) throws NoSuchMethodException {
        Method method = targetClass.getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        return method;
    }

}
