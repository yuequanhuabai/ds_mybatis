package com.ex.controller;


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

    public static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Resource
    private StudentService studentService;


    @PostMapping("/queryStus")
    public List<Student> queryStudents() {
        List<Student> students = studentService.queryStus("zhangsan", 10, 1);
        logger.info("students: " + students);

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


    // 官网:
    // mime 类型
    // contextType: https://www.iana.org/assignments/media-types/media-types.xhtml


}
