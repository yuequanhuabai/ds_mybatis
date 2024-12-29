package com.ex.dynamic;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
public class DataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static List<String> dataSourceIds = new ArrayList<>();

    private static Map<String,String> schemaMap = new HashMap();


    /**
     *  设置数据源
     * @param dsName
     */
    public static void setDataSourceType(String dsName) {
         log.info("切换到["+dsName+"]数据源");
        contextHolder.set(dsName);
    }

    /**
     * 获取数据源
     * @return
     */
    public static String getDataSourceType() {
        return contextHolder.get();
    }

    /**
     * 清除数据源
     */
    public static void clearDataSourceType() {
        contextHolder.remove();
    }




}
