package com.ex.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Slf4j
@Service
public class DynamicDataSourceService {

    private Logger logger = LoggerFactory.getLogger(DynamicDataSourceService.class);


    @Resource
    private DataSource dataSource;




}
