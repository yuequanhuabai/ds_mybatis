package com.ex.service;


import com.ex.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> queryStus(String name, Integer pageSize, Integer pageNum);

    Integer insertStudent(Student student);



}
