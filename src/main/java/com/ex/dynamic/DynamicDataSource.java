package com.ex.dynamic;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源：负责数据源的动态切换
 * 根据DataSourceContextHolder设置的值切换
 */
public class DynamicDataSource extends AbstractRoutingDataSource {


    private Map<Object,Object> targetDataSources;

    private Object defaultTargetDataSource;

    private boolean lenientFallback = true;

    private  Map<Object, DataSource> resolvedDataSources;

    private DataSource resolvedDefaultDataSource;


    public DataSource getResolvedDefaultDataSource() {
        return this.resolvedDefaultDataSource;
    }

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        this.targetDataSources = targetDataSources;
    }

    @Override
    public void setDefaultTargetDataSource(Object defaultTargetDataSource) {
        this.defaultTargetDataSource = defaultTargetDataSource;
    }

    @Override
    public void setLenientFallback(boolean lenientFallback) {
        this.lenientFallback = lenientFallback;
    }

    /**
     *  自定义方法： 动态添加数据源到 resolvedDataSource
     * @param key
     * @param value
     */
    public void addResovleDataSource(String key, Object value) {
        if (this.resolvedDataSources == null) {
            resolvedDataSources = new HashMap<Object, DataSource>();
        }
        Object lookupKey = resolveSpecifiedLookupKey(key);
        DataSource dataSource = resolveSpecifiedDataSource(value);
        this.resolvedDataSources.put(lookupKey,dataSource);
    }

    /**
     *  自定义方法： 移除resolvedDataSources中的动态添加数据源
     * @param key
     */
    public void delResolvedDataSource(String key) {
        if (resolvedDataSources == null) {
            return;
        }
        if(resolvedDataSources.containsKey(key)){
            this.resolvedDataSources.remove(key);
        }
    }



    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSourceType();
    }


    @Override
    protected DataSource determineTargetDataSource() {

        Assert.notNull(this.resolvedDataSources,"DataSource router  not initailized");

        Object lookupKey = determineCurrentLookupKey();
        DataSource dataSource = this.resolvedDataSources.get(lookupKey);
        if (dataSource == null && (this.lenientFallback || lookupKey == null) )  {
            dataSource=this.resolvedDefaultDataSource;
        }

        if(dataSource==null){
            throw new IllegalStateException("Cannot determine target data source for lookup key [ " + lookupKey+"]");
        }


        return  dataSource;

    }

    @Override
    public void afterPropertiesSet() {

        if(this.targetDataSources==null){
            throw new IllegalArgumentException("property 'targetDataSources' is required");
        }

        this.resolvedDataSources = new HashMap<>();

        this.targetDataSources.forEach(
                (key,value)->{
                    Object lookupKey = resolveSpecifiedLookupKey(key);
                    DataSource dataSource = resolveSpecifiedDataSource(value);
                    this.resolvedDataSources.put(lookupKey,dataSource);
                }
        );

        if(this.defaultTargetDataSource!=null){
            this.resolvedDefaultDataSource = resolveSpecifiedDataSource(this.defaultTargetDataSource);
        }
    }
}
