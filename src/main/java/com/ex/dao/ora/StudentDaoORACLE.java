package com.ex.dao.ora;

import com.ex.dao.StudentDao;
import com.ex.entity.Student;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
//@Primary
@Repository
public class StudentDaoORACLE implements StudentDao {

    @Resource(name = "sqlSessionTemplateOracle")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<Student> queryStus(Map<String, Object> map) {
        return sqlSessionTemplate.selectList("StudentMapperOracle.queryStus",map);
    }

    @Override
    public Integer insertStu(Student student) {
        return sqlSessionTemplate.insert("StudentMapperOracle.insertStu", student);

    }

}
