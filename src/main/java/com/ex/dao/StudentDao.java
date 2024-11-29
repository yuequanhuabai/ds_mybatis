package com.ex.dao;

import com.ex.entity.Student;

import java.util.List;


public interface StudentDao {

    List<Student> queryStus();

    Integer insertStu(Student student);

}
