package com.ex.dao.mysql;

import com.ex.dao.UserLogDao;
import com.ex.entity.UserLog;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
@Primary
@Repository
public class UserLogDaoMYSQL implements UserLogDao {

    @Resource(name = "sqlSessionTemplateMysql")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(UserLog userLog) {
        return sqlSessionTemplate.insert("UserLogMapperMysql.insertUserLog", userLog);
    }


}
