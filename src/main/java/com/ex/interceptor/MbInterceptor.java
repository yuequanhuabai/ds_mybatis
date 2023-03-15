package com.ex.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
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

import java.sql.Connection;
import java.util.Properties;

@Slf4j
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class,Integer.class})})
@Component
public class MbInterceptor implements Interceptor {

    private static final String DELEGATE_BOUNDSQL_SQL="DELEGATE_BOUNDSQL_SQL";

    private static final String DELEGATE_MAPPED_STATEMENT="DELEGATE_MAPPED_STATEMENT";

    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();

    private static final DefaultObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

    private static final ReflectorFactory  DEFAULT_REFLECTOR_FACTORY = new DefaultReflectorFactory();


    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        log.info("进入intercept...");

        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();

        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY, DEFAULT_REFLECTOR_FACTORY);

        String sql = (String)metaStatementHandler.getValue(DELEGATE_BOUNDSQL_SQL);

       final MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue(DELEGATE_MAPPED_STATEMENT);


        String qualifiedName = mappedStatement.getId();

        log.info("qualifiedName: "+qualifiedName);

        String className = qualifiedName.substring(0, qualifiedName.lastIndexOf(".")) + "Dao";

        String methodName = qualifiedName.substring(qualifiedName.lastIndexOf(".") + 1, qualifiedName.length());


        log.info("className:"+className);
        log.info("methodName:"+methodName);

//        Class.forName(className).getAnnotation(DynamicDataSource.class)



        return null;
    }

    @Override
    public Object plugin(Object target) {
        return null;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
