package com.ex.controller;


import com.ex.dao.DataSourceModelDao;
import com.ex.dao.PersonDao;
import com.ex.ds.DynamicDataSourceContextHolder;
import com.ex.entity.Person;
import com.ex.entity.Student;
import com.ex.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@ResponseBody
@RequestMapping("/test")
@Controller
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Resource
    private StudentService studentService;

    @Resource
    private PersonDao personDao;

    @Resource
    private DataSourceModelDao dataSourceModelDao;


    @GetMapping("/queryStus")
    public List<Student> queryStudents() {

//        DynamicDataSourceContextHolder.clearDataSource();
//        DynamicDataSourceContextHolder.setDataSource("test1");
        List<Student> students = studentService.queryStus("zhangsan", 10, 1);
        logger.info("students: " + students);
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

    @RequestMapping("getFile")
    public void getFile() {
        studentService.getExcel();
    }


    @PostMapping("/insertStu")
    public Integer insertStu(@RequestBody Student student) {
        Integer integer = studentService.insertStudent(student);
        return integer;
    }


    @PostMapping("/queryPerson")
    public List<Person> queryPerson() {
        DynamicDataSourceContextHolder.clearDataSource();
        DynamicDataSourceContextHolder.setDataSource("test2");
        List<Person> peoples = personDao.queryAllPerson();

        return peoples;
    }

    // 官网:
    // mime 类型
    // contextType: https://www.iana.org/assignments/media-types/media-types.xhtml



}
