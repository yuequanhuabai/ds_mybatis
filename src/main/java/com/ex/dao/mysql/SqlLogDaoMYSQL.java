//package com.ex.dao.mysql;
//
//import com.ex.dao.SqlLogDao;
//import com.ex.entity.SqlLog;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.Resource;
//
//@Repository
//public class SqlLogDaoMYSQL implements SqlLogDao {
//
//
//    @Resource(name = "sqlSessionTemplateMysql")
//    private SqlSessionTemplate sqlSessionTemplate;
//
//    @Override
//    public int insert(SqlLog record) {
//
//        return sqlSessionTemplate.insert("SqlLogMapperMysql.insertSqlLog", record);
//    }
//}
