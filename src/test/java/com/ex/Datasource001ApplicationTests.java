package com.ex;

import com.ex.dao.DataSourceModelDao;
import com.ex.dao.PersonDao;
import com.ex.dao.StudentDao;
import com.ex.dao.SysLogsDao;
import com.ex.entity.DataSourceModel;
import com.ex.entity.Person;
import com.ex.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class Datasource001ApplicationTests {

    @Resource
    private StudentDao studentDao;

    @Resource
    private PersonDao personDao;

    @Resource
    private SysLogsDao sysLogsDao;

    @Resource
    private DataSourceModelDao dataSourceModelDao;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ApplicationContext ctx;


     @Test
    void contextLoads() {

        List<Student> students = studentDao.queryStus();
        System.out.println(students);
    }

    @Test
    void contextLoads2() {

        List<DataSourceModel> dataSourceModels = dataSourceModelDao.queryAll();

        System.out.println(dataSourceModels);
    }

    @Test
    void contextLoads3() throws SQLException {


        System.out.println(dataSource.getClass());

        System.out.println("datasource:  " + dataSource.getClass());
        Connection connection = dataSource.getConnection();
        String sql = "select * from" +
                " student";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Statement statement = connection.createStatement();
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Student> studentList = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);

            Student student = new Student();

            student.setId(id);
            student.setName(name);

            studentList.add(student);
        }
        System.out.println("====================================");
        System.out.println(studentList);

    }


    @Test
    void contextLoads4() {

//        DynamicDataSourceContextHolder.setDataSource("test2");
        List<Person> peoples = personDao.queryAllPerson();

        System.out.println(peoples);
    }

    @Test
    void contextLoads5() {

//        List<Student> studentList = stuDao.selectList();
//        System.out.println(studentList);
    }


    @Test
    void contextLoads6() {
//        StudentServiceImpl studentServiceImpl = ctx.getBean("studentServiceImpl", StudentServiceImpl.class);
//        System.out.println("=====class=====");
//        log.info(studentServiceImpl.getClass().toString());
//        System.out.println("=====class=====");
//        List<Student> studentList = studentServiceImpl.queryStus();
//       studentList.stream().forEach(System.out::println);

    }


    @Test
    void contextLoads7() {
        System.out.println("==");
    }

    public static void main(String[] args) {
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd HH:mm:ss", Locale.CHINA);
//        System.out.printf("==============="+dateTimeFormatter.toString());

    }


}
