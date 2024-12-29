package com.ex.dynamic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Slf4j
@Service
public class DynamicDataSourceService {

    private Logger logger = LoggerFactory.getLogger(DynamicDataSourceService.class);

//    @Resource(lookup = "dataSourceMysql")
    @Autowired
    @Qualifier("dataSourceMysql")
    private DataSource dataSource;




}
