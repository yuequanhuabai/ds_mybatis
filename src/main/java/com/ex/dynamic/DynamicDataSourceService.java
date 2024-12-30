package com.ex.dynamic;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.util.StringUtils;
import com.ex.entity.DataSourceModel;
import com.ex.utils.JDBCUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DynamicDataSourceService {

    private Logger logger = LoggerFactory.getLogger(DynamicDataSourceService.class);


//    @Resource

    @Autowired
//    @Qualifier("dynamicDataSource")
    private DataSource dataSource;


     public List<DataSourceModel> findAllDataSource() throws SQLException {
         List<DataSourceModel> dataModelList = JDBCUtils.getDataModelList();
         if (CollectionUtils.isEmpty(dataModelList)) {
             dataModelList=new ArrayList<>();
         }
         return dataModelList;
     }




    public int deleteDataSourceByName(String dsName) throws SQLException {
         if(StringUtils.isEmpty(dsName)){
             return 0;
         }
         return 1;

//         delDataSourceToResovledCache(dsName);
     }


     public  void addDataSource(DataSourceModel model) throws SQLException {

         addDataSourceToResolvedCache(model);
//         addDataSourceToDB(model);

     }


     public void addDataSourceToResolvedCache(DataSourceModel model)  {
          DruidDataSource ds = new DruidDataSource();
          ds.setDriverClassName(model.getDriverClassName());
          ds.setUrl(model.getUrl());
          ds.setUsername(model.getUsername());
          ds.setPassword(model.getPassword());
          if(model.getDsType() !=null){
              ds.setDbType(model.getDsType());
          }
         try {
             ds.init();
         } catch (SQLException e) {
             logger.error(e.getMessage());
             throw new RuntimeException(e);
         }

         MyRoutingDataSource dds = (MyRoutingDataSource) dataSource;
//         dds.addResovleDataSource(model.getDsName(), ds);
     }

     public void delDataSourceToResolvedCache(String dsName) throws SQLException {
         DruidDataSource ds =  (DruidDataSource) dataSource;

//         ds.delResolvedDataSource(dsName);
     }

     public  void changeDataSource(String dsName ) throws SQLException {
         DataSourceContextHolder.setDataSourceType(dsName);
     }

     public void resetDefaultDataSource() throws SQLException {
         DataSourceContextHolder.clearDataSourceType();
     }

     public String getCurrentDataSource() throws SQLException {
         return DataSourceContextHolder.getDataSourceType();
     }


     @PostConstruct
     private void initTargetDataSource() throws SQLException {

         List<DataSourceModel> list = findAllDataSource();
         if(CollectionUtils.isEmpty(list)){
             list.stream().forEach(
                     m->addDataSourceToResolvedCache(m)
             );
         }
     }






}
