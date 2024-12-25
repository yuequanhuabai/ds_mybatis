package com.ex.controller;


import com.ex.dao.StudentDao;
import com.ex.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ResponseBody
@RequestMapping("/test")
@Controller
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

//    @Resource
//    private StudentService studentService;

    @Resource
    private StudentDao studentDao;


    @PostMapping("/queryStus")
    public List<Student> queryStudents() {

        Map<String, Object> map = new HashMap<>();
        List<Student> students = studentDao.queryStus(map);
//        List<Student> students = studentService.queryStus("zhangsan", 10, 1);
        logger.info("students: " + students);


        return students;
    }


    @PostMapping("/insertStu")
    public Integer insertStu(@RequestBody Student student) {
        Integer integer = studentDao.insertStu(student);
        return integer;
    }


    // 官网:
    // mime 类型
    // contextType: https://www.iana.org/assignments/media-types/media-types.xhtml


}
