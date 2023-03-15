package com.ex.ds;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
//@Service
public class DynamicDataSource extends AbstractRoutingDataSource {

    private Map<Object, Object> targetDataSources;

    private Object defaultTargetDataSource;

    private boolean lenientFallback = true;

    private Map<Object, DataSource> resolvedDataSource;

    private DataSource resolvedDefaultDataSource;


    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
//        super.setTargetDataSources(targetDataSources);
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

    public void addResolvedDataSource(String key, Object value) {
        if (this.resolvedDataSource == null) {
            resolvedDataSource = new HashMap<>();
        }
        Object lookupKey = resolveSpecifiedLookupKey(key);
        DataSource dataSource = resolveSpecifiedDataSource(value);
        this.resolvedDataSource.put(lookupKey, dataSource);

    }

    public void delResolvedDataSource(String key) {
        if (this.resolvedDataSource == null) {
            return;
        }
        if (this.resolvedDataSource.containsKey(key)) {
            this.resolvedDataSource.remove(key);
        }

    }

    public DataSource getResolvedDefaultDataSource() {
        return this.resolvedDefaultDataSource;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSource();
    }

    @Override
    protected DataSource determineTargetDataSource() {
        Object lookupKey = determineCurrentLookupKey();
        DataSource dataSource = this.resolvedDataSource.get(lookupKey);
        if (dataSource == null && (this.lenientFallback || lookupKey == null)) {
            dataSource = this.resolvedDefaultDataSource;
        }
        if (dataSource == null) {
            throw new IllegalStateException("Cannot determine target Datasource for lookup key [" + lookupKey + "]");
        }

        return dataSource;
    }

    @Override
    public void afterPropertiesSet() {
        if (this.targetDataSources == null) {
            throw new IllegalArgumentException("Property 'targetDataSource' is required");
        }
        this.resolvedDataSource = new HashMap<>();
        this.targetDataSources.forEach(
                (key, value) -> {
                    Object lookupKey = resolveSpecifiedLookupKey(key);
                    DataSource dataSource = resolveSpecifiedDataSource(value);
                    this.resolvedDataSource.put(lookupKey, dataSource);
                }
        );

        if (this.defaultTargetDataSource != null) {
            this.resolvedDefaultDataSource = resolveSpecifiedDataSource(this.defaultTargetDataSource);
        }


    }
}
