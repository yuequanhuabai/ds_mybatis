package com.ex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@MapperScan("com.ex.dao")
//@MapperScan(value={"com.ex.dao"})
//@MapperScans(value={"com.ex.dao","com.ex.dao2"})
@SpringBootApplication
public class Datasource001Application {

    public static void main(String[] args) {
        SpringApplication.run(Datasource001Application.class, args);
    }

}
