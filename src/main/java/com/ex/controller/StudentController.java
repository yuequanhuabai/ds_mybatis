package com.ex.controller;


import com.ex.dao.DataSourceModelDao;
import com.ex.dao.PersonDao;
import com.ex.ds.DynamicDataSourceContextHolder;
import com.ex.entity.Person;
import com.ex.entity.Student;
import com.ex.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@ResponseBody
@RequestMapping("/test")
@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    @Resource
    private PersonDao personDao;

    @Resource
    private DataSourceModelDao dataSourceModelDao;


    @PostMapping("/queryStus")
    public List<Student> queryStudents() {
        DynamicDataSourceContextHolder.clearDataSource();
        DynamicDataSourceContextHolder.setDataSource("test1");
        List<Student> students = studentService.queryStus("zhangsan", 10, 1);

//        DataSourceModel model = new DataSourceModel();
//        model.setCreateTime(new Date());
//        model.setCreator("zhangsan");
//        model.setDsid(UUID.randomUUID().toString().replaceAll("-",""));
//        model.setDsName("test2");
//        model.setDsType("mysql");
//        model.setUsername("root");
//        model.setPassword("root");
//        model.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        model.setUrl("jdbc:mysql://localhost:3306/test2?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&useSSL=false");
//
//        int i = dataSourceModelDao.insertDataSourceModel(model);
//        System.out.printf("i:"+i);
        return students;
    }


    @PostMapping("/insertStu")
    public Integer insertStu( @RequestBody Student student){
        Integer integer = studentService.insertStudent(student);
        return  integer;
    }


    @PostMapping("/queryPerson")
    public List<Person> queryPerson() {
        DynamicDataSourceContextHolder.clearDataSource();
        DynamicDataSourceContextHolder.setDataSource("test2");
        List<Person> peoples = personDao.queryAllPerson();

        return peoples;
    }




}
