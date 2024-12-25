package com.ex.aop;


import com.ex.anon.OperateLog;
import com.ex.dao.StudentDao;
import com.ex.dao.UserLogDao;
import com.ex.entity.UserLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.UUID;

@Component
@Aspect
public class LogRespect {

    @Resource
    private StudentDao studentDao;

    @Resource
    private UserLogDao userLogDao;


    @Pointcut("@annotation(com.ex.anon.OperateLog)")
    public void logPoint() {
    }


    @Around("logPoint()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {


        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        long spend = end - start;

        saveLog(joinPoint, start, end, spend);


        return result;
////        Class<?> aClass = joinPoint.getTarget().getClass();
//
//
//        // 获取目标类
//
//        Object[] args = joinPoint.getArgs();
//        Object target = joinPoint.getTarget();
//        String kind = joinPoint.getKind();
//
//
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//
//        String name1 = signature.getName();
//        Class[] parameterTypes = signature.getParameterTypes();
//        Method declaredMethod = aClass.getDeclaredMethod(name1, parameterTypes);
//        OperateLog annotation1 = declaredMethod.getAnnotation(OperateLog.class);
//        String operate1 = annotation1.operate();
//
//
//        Method method = signature.getMethod();
//        OperateLog annotation = method.getAnnotation(OperateLog.class);
//        String operate = annotation.operate();
//
//
//        String name = signature.getName();
//        String declaringTypeName = signature.getDeclaringTypeName();
//        Class declaringType = signature.getDeclaringType();
//        SourceLocation sourceLocation = joinPoint.getSourceLocation();
//        Object aThis = joinPoint.getThis();
//
//        System.out.println("hello !");
//
//
//        return result;
    }

    private void saveLog(ProceedingJoinPoint joinPoint, long start, long end, long spend) throws NoSuchMethodException {

        Object target = joinPoint.getTarget();

        // 获取拦截的目标类
        Class<?> aClass = target.getClass();
        String className = aClass.getName();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = className + "." + signature.getName();

        Method declaredMethod = aClass.getDeclaredMethod(signature.getName(), signature.getParameterTypes());
        OperateLog annotation = declaredMethod.getAnnotation(OperateLog.class);
        String operate = annotation.operate();


        UserLog userLog = new UserLog();
        userLog.setId(UUID.randomUUID().toString());
        userLog.setStart(start);
        userLog.setEnd(end);
        userLog.setSpend(spend);
        userLog.setIp("127.0.0.1");
        userLog.setTargetClass(className);
        userLog.setMethod(methodName);
        userLog.setOperation(operate);
        String param = Arrays.toString(joinPoint.getArgs());
        userLog.setParam(param);
        userLog.setUsername("zhangsan");

        userLogDao.insert(userLog);

    }

}
