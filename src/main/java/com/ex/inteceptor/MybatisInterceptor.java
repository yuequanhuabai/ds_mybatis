package com.ex.inteceptor;

import com.alibaba.druid.pool.DruidDataSource;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.UUID;


@Service
@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})

})
public class MybatisInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger(MybatisInterceptor.class);

    private Integer defaultLimit;

//    @Resource
//    private UserLogDao sserLogDao;

//    @Resource
//    private SqlLogDao sqlLogDao;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

//        Object[] args = invocation.getArgs();
//        Method method = invocation.getMethod();
//        Object target = invocation.getTarget();
//        Class<? extends Invocation> aClass = invocation.getClass();
//
//        String path = "config/whiteList.properties";
//        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);

        Object[] args = invocation.getArgs();
        String methodName = invocation.getMethod().getName();
        long start = System.currentTimeMillis();

        Timestamp timestampstart = new Timestamp(start);

        Object result = invocation.proceed();
        long end = System.currentTimeMillis();
        Timestamp timestampend = new Timestamp(end);
        long spend = end - start;

        asyncLog(args, spend, invocation, methodName, timestampstart, timestampend);


        return result;
    }

    private void asyncLog(Object[] args, long spend, Invocation invocation, String methodName, Timestamp timestampstart, Timestamp timestampend) throws JsonProcessingException {
        int length = args.length;
        logger.info("length is :{}", length);
        logger.info("spend is :{}", spend);
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameter = args[1];
        String param = new ObjectMapper().writeValueAsString(parameter);

        String sqlId = mappedStatement.getId();
        Configuration configuration = mappedStatement.getConfiguration();
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);

        String sql = boundSql.getSql();

//        DataSource dataSource = configuration.getEnvironment().getDataSource();
        Environment environment = configuration.getEnvironment();

        DruidDataSource dataSource = (DruidDataSource) environment.getDataSource();

//        DruidDataSource dataSource = (DruidDataSource) configuration.getEnvironment().getDataSource();

        String jdbcPrepareSql = getPrepareSql();


        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(jdbcPrepareSql)
        ) {
            String url = dataSource.getUrl();
            String username = dataSource.getUsername();
            String password = dataSource.getPassword();
            String dbType = dataSource.getDbType();


            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, dbType);
            preparedStatement.setString(3, param);
            preparedStatement.setString(4, url);
            preparedStatement.setString(5, username);
            preparedStatement.setString(6, password);


            int i = preparedStatement.executeUpdate();


//            "INSERT INTO test.log\n" +
//                    "(id, db_type, param, url, username, password)\n" +
//                    "VALUES(?, ?, ?, ?, ?, ?);";

//            SqlLog sqlLog = new SqlLog();
//            sqlLog.setId(UUID.randomUUID().toString());
//            sqlLog.setUsername(username);
//            sqlLog.setUrl(url);
//            sqlLog.setDbType(dbType);
//            sqlLog.setParam(param);
//            sqlLog.setPassword(password);
//
//            sqlLogDao.insert(sqlLog);

            logger.info("finished");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    private String getPrepareSql() {
        String sql = "INSERT INTO test.log\n" +
                "(id, db_type, param, url, username, password)\n" +
                "VALUES(?, ?, ?, ?, ?, ?);";

        return sql;
    }

    @Override
    public Object plugin(Object target) {
        return Interceptor.super.plugin(target);
    }

    @Override
    public void setProperties(Properties properties) {
        Interceptor.super.setProperties(properties);
    }
}
