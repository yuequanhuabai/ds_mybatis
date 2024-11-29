package com.ex.service.impl;

import com.ex.dao.StudentDao;
import com.ex.entity.Student;
import com.ex.service.StudentService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public List<Student> queryStus(String name, Integer pageSize, Integer pageNum) {
        List<Student> students = studentDao.queryStus();
        return students;
    }


    @Override
    public Integer insertStudent(Student student) {
        Integer integer = studentDao.insertStu(student);
        return integer;
    }



    }



