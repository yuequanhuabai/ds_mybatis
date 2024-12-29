package com.ex.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicDataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static List<String> dataSourceIds = new ArrayList<>();

    private static Map<String,String> schemaMap = new HashMap();


    /**
     *  设置数据源
     * @param dataSourceType
     */
    public static void setDataSourceType(String dataSourceType) {
        contextHolder.set(dataSourceType);
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
