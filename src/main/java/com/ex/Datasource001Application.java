package com.ex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;

@EnableAsync
@MapperScan("com.ex.dao")
//@MapperScan(value={"com.ex.dao"})
//@MapperScans(value={"com.ex.dao","com.ex.dao2"})
@SpringBootApplication
public class Datasource001Application {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        SpringApplication.run(Datasource001Application.class, args);


    }









}
