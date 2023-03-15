package com.ex.service.impl;

import com.ex.annotation.AopAnnotation;
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

    @AopAnnotation("查询所有学生操作")
    @Override
    public List<Student> queryStus(String name, Integer pageSize, Integer pageNum) {
        List<Student> students = studentDao.queryStus();
        return students;
    }


    @AopAnnotation("新增student操作")
    @Override
    public Integer insertStudent(Student student) {
        Integer integer = studentDao.insertStu(student);
        return integer;
    }


}
