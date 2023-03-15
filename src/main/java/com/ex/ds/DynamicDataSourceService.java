package com.ex.ds;

//import com.alibaba.druid.pool.DruidDataSourceWrapper;

import com.alibaba.druid.pool.DruidDataSource;
import com.ex.conf.DruidConfig;
import com.ex.entity.DataSourceModel;
import com.ex.util.JdbcUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//@Component
@Service
@Slf4j
public class DynamicDataSourceService {

    @Autowired
    private DruidConfig druidConfig;


    @Autowired
    @Qualifier("dynamicDataSource")
    private DynamicDataSource dynamicDataSource;


//     @Resource
//    private DataSourceModelDao dataSourceModelDao;

//    // TODO
    // 类型转换异常

    public void addDataSourceToResolvedCache(DataSourceModel model) {

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(model.getDriverClassName());
        dataSource.setUrl(model.getUrl());
        dataSource.setUsername(model.getUsername());
        dataSource.setPassword(model.getPassword());

        try {
            dataSource.init();
        } catch (SQLException e) {
            log.error(e.toString());
            e.printStackTrace();
            throw new RuntimeException("数据源初始化失败！");
        }

        DynamicDataSource dds = (DynamicDataSource) dynamicDataSource;
        dds.addResolvedDataSource(model.getDsName(), dataSource);
    }


    @PostConstruct
    private void initTargetDataSource() {
        log.info("===============PostConstruct===================");

        DynamicDataSourceContextHolder.setDataSource("");

        List<DataSourceModel> dataSourceModels = new ArrayList<>();
        try {
            dataSourceModels = JdbcUtil.getQueryResults();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


//        List<DataSourceModel> dataSourceModels = dataSourceModelDao.queryAllDataSourceModels();
//        List<DataSourceModel> dataSourceModels= new ArrayList<>();

        log.info("================================================");
        log.info("init list =" + dataSourceModels.size());
        log.info("================================================");

        if (!CollectionUtils.isEmpty(dataSourceModels)) {
            dataSourceModels.stream().forEach(e -> addDataSourceToResolvedCache(e));
        }

    }
//
//
}
