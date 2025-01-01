package com.ex.dao.ora;

import com.ex.dao.UserLogDao;
import com.ex.entity.UserLog;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
//@Primary
@Repository
public class UserLogDaoORACLE implements UserLogDao {

    @Resource(name = "sqlSessionTemplateOracle")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int insert(UserLog userLog) {
        return sqlSessionTemplate.insert("UserLogMapperOracle.insertUserLog",userLog);
    }
}
