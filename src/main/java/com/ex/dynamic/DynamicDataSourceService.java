package com.ex.dynamic;

import com.alibaba.druid.pool.DruidDataSource;
import com.ex.entity.DataSourceModel;
import com.ex.repository.DataSourceConfigRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class DynamicDataSourceService {

    @Autowired
    private DataSourceConfigRepository dataSourceConfigRepository;

    @Autowired
    private DruidDataSourceFactory druidDataSourceFactory;

    private Map<Object,Object> slaveDataSources = new HashMap<>();

    @Autowired
    private MyRoutingDataSource routingDataSource ;

    @PostConstruct
    public void init(){
        loadSlaveDataSource();
        log.info("");
    }

    private void loadSlaveDataSource() {
        List<DataSourceModel> all = dataSourceConfigRepository.findAll();
        for (DataSourceModel dataSourceModel : all) {
            if(!slaveDataSources.containsKey(dataSourceModel.getDsName())){
                DruidDataSource dataSource = druidDataSourceFactory.createDataSource(dataSourceModel);
                slaveDataSources.put(dataSourceModel.getDsName(), dataSource);
                routingDataSource.setTargetDataSources(slaveDataSources);
                routingDataSource.afterPropertiesSet();
            }
        }
    }



    public Map<Object,Object> getSlaveDataSources(){
        return slaveDataSources;
    }


    public void addDataSource(DataSourceModel dataSourceModel){
        if(!slaveDataSources.containsKey(dataSourceModel.getDsName())){
            DruidDataSource dataSource = druidDataSourceFactory.createDataSource(dataSourceModel);
            slaveDataSources.put(dataSourceModel.getDsName(), dataSource);
            updateRoutingDataSource();
        }
    }

    public void removeDataSource(String name){
        if(slaveDataSources.containsKey(name)){
            DruidDataSource ds = (DruidDataSource) slaveDataSources.remove(name);
            if(ds != null){
                ds.close();
            }
            updateRoutingDataSource();
        }
    }

    private void updateRoutingDataSource() {
        Map<Object,Object> targetDataSource = new HashMap<>();

        targetDataSource.put("master",routingDataSource.getResolvedDefaultDataSource());
        targetDataSource.putAll(slaveDataSources);
        routingDataSource.setTargetDataSources(targetDataSource);
        routingDataSource.afterPropertiesSet();
    }

    public boolean containsDataSource(String name){
        return slaveDataSources.containsKey(name) || "master".equals(name);
    }


//    private Logger logger = LoggerFactory.getLogger(DynamicDataSourceService.class);
//
//
////    @Resource
//
//    @Autowired
////    @Qualifier("dynamicDataSource")
//    private DataSource dataSource;
//
//
//     public List<DataSourceModel> findAllDataSource() throws SQLException {
//         List<DataSourceModel> dataModelList = JDBCUtils.getDataModelList();
//         if (CollectionUtils.isEmpty(dataModelList)) {
//             dataModelList=new ArrayList<>();
//         }
//         return dataModelList;
//     }
//
//
//
//
//    public int deleteDataSourceByName(String dsName) throws SQLException {
//         if(StringUtils.isEmpty(dsName)){
//             return 0;
//         }
//         return 1;
//
////         delDataSourceToResovledCache(dsName);
//     }
//
//
//     public  void addDataSource(DataSourceModel model) throws SQLException {
//
//         addDataSourceToResolvedCache(model);
////         addDataSourceToDB(model);
//
//     }
//
//
//     public void addDataSourceToResolvedCache(DataSourceModel model)  {
//          DruidDataSource ds = new DruidDataSource();
//          ds.setDriverClassName(model.getDriverClassName());
//          ds.setUrl(model.getUrl());
//          ds.setUsername(model.getUsername());
//          ds.setPassword(model.getPassword());
//          if(model.getDsType() !=null){
//              ds.setDbType(model.getDsType());
//          }
//         try {
//             ds.init();
//         } catch (SQLException e) {
//             logger.error(e.getMessage());
//             throw new RuntimeException(e);
//         }
//
//         MyRoutingDataSource dds = (MyRoutingDataSource) dataSource;
////         dds.addResovleDataSource(model.getDsName(), ds);
//     }
//
//     public void delDataSourceToResolvedCache(String dsName) throws SQLException {
//         DruidDataSource ds =  (DruidDataSource) dataSource;
//
////         ds.delResolvedDataSource(dsName);
//     }
//
//     public  void changeDataSource(String dsName ) throws SQLException {
//         DataSourceContextHolder.setDataSourceType(dsName);
//     }
//
//     public void resetDefaultDataSource() throws SQLException {
//         DataSourceContextHolder.clearDataSourceType();
//     }
//
//     public String getCurrentDataSource() throws SQLException {
//         return DataSourceContextHolder.getDataSourceType();
//     }
//
//
//     @PostConstruct
//     private void initTargetDataSource() throws SQLException {
//
//         List<DataSourceModel> list = findAllDataSource();
//         if(CollectionUtils.isEmpty(list)){
//             list.stream().forEach(
//                     m->addDataSourceToResolvedCache(m)
//             );
//         }
//     }






}
