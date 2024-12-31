package com.ex.dynamic;

import com.alibaba.druid.pool.DruidDataSource;
import com.ex.entity.DataSourceModel;
import org.springframework.stereotype.Component;

@Component
public class DruidDataSourceFactory {

    public DruidDataSource createDataSource(DataSourceModel dataSourceModel){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(dataSourceModel.getDriverClassName());
        ds.setUrl(dataSourceModel.getUrl());
        ds.setUsername(dataSourceModel.getUsername());
        ds.setPassword(dataSourceModel.getPassword());

        return ds;
    }

}
