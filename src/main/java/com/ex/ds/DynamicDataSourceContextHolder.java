package com.ex.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicDataSourceContextHolder {
    public static Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    public static final ThreadLocal<String> context_holer = new ThreadLocal<>();


    public static void setDataSource(String dsName) {
        logger.info("切换到【" + dsName + "】数据源");
        context_holer.set(dsName);
    }

    public static String getDataSource() {
        return context_holer.get();
    }

    public static void clearDataSource() {
        context_holer.remove();
    }

}
