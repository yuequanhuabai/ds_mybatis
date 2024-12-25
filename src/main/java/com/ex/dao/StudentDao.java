package com.ex.dao;

import com.ex.entity.Student;

import java.util.List;
import java.util.Map;


public interface StudentDao {
    //    com.ex.dao.StudentDao.queryStus
    List<Student> queryStus(Map<String, Object> map);

    Integer insertStu(Student student);

}
