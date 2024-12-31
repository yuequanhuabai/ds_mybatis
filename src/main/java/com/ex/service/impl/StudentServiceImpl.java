package com.ex.service.impl;


import com.ex.dao.StudentDao;
import com.ex.dynamic.DataSourceContextHolder;
import com.ex.entity.Student;
import com.ex.repository.StudentRepository;
import com.ex.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {


    private StudentDao studentDao;

    @Resource
    private StudentRepository studentRepository;

    @Override
    public List<Student> queryStus(String name, Integer pageSize, Integer pageNum) {
        Map<String, Object> map = new HashMap<String, Object>();
//
        DataSourceContextHolder.setDataSourceType("ds2");
        List<Student> students = studentRepository.findAll();
//        DataSourceContextHolder.clearDataSourceType();
//        List<Student> students = studentDao.queryStus(map);
        return students;
    }

    @Override
    public Integer insertStudent(Student student) {
        Integer integer = studentDao.insertStu(student);
        return integer;
    }



    }



