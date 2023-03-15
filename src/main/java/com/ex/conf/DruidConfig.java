package com.ex.conf;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.ex.ds.DynamicDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;

@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DruidConfig {

//    initialsize: 5
//    minidea: 5
//    maxactive: 100
//    maxwait: 60000

    private Integer initialSize;

    private Integer minIdle;

    private Integer maxActive;

    private Integer maxWait;

    public void copyFields2DataSource(DruidDataSource dataSource) {
        dataSource.setMinIdle(this.minIdle);
        dataSource.setMaxWait(this.maxWait);
        dataSource.setInitialSize(this.initialSize);
        dataSource.setMaxWait(this.maxActive);
    }

    // 给数据源注入除url，driverClass，username，password以外的其他字段；这四个字段在进行查询数据库的时候再注入
    @Bean
    public DruidDataSource defaultDataSource() {
        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
        copyFields2DataSource(druidDataSource);
        int initialSize = druidDataSource.getInitialSize();
        log.info("=================================================initialSize: " + initialSize);
        return druidDataSource;
    }


    @Primary
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource initDynamicDataSource(DruidDataSource dataSource) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(dataSource);
        dynamicDataSource.setTargetDataSources(new HashMap<>());
        return dynamicDataSource;
    }


}
