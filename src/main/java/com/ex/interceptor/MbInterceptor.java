package com.ex.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Timestamp;

// 也可以拦截Executor接口核心类；可以实现sql的审计记录；
@Slf4j
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})})
@Component
public class MbInterceptor implements Interceptor {

    private static final String DELEGATE_BOUNDSQL_SQL = "DELEGATE_BOUNDSQL_SQL";

    private static final String DELEGATE_MAPPED_STATEMENT = "DELEGATE_MAPPED_STATEMENT";

    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();

    private static final DefaultObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

    private static final ReflectorFactory DEFAULT_REFLECTOR_FACTORY = new DefaultReflectorFactory();


    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        log.info("进入intercept...");

        long start = System.currentTimeMillis();
        Timestamp startTime = new Timestamp(start);
        Object proceed = invocation.proceed();
        long end = System.currentTimeMillis();
        Timestamp endTime = new Timestamp(end);

        Object[] args = invocation.getArgs();
        Method method = invocation.getMethod();
        String methodName = method.getName();

        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
    
        BoundSql boundSql = statementHandler.getBoundSql();

        Object parameterObject = boundSql.getParameterObject();


        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY, DEFAULT_REFLECTOR_FACTORY);

        String sql = (String) metaStatementHandler.getValue(DELEGATE_BOUNDSQL_SQL);

        final MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue(DELEGATE_MAPPED_STATEMENT);


        String qualifiedName = mappedStatement.getId();

        log.info("qualifiedName: " + qualifiedName);

        String className = qualifiedName.substring(0, qualifiedName.lastIndexOf(".")) + "Dao";



        log.info("className:" + className);
        log.info("methodName:" + methodName);


        return proceed;
    }


}
