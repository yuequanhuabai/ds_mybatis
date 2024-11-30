package com.ex.dao.mysql;

import com.ex.dao.StudentDao;
import com.ex.entity.Student;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

public class StudentDaoMYSQL implements StudentDao {

//    @Resource(name = "sqlSessionTemplateMysql")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<Student> queryStus(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("StudentMapperMysql.queryStus",map);
    }


}
