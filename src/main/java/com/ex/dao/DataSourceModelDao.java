package com.ex.dao;

import com.ex.entity.DataSourceModel;

import java.util.List;


public interface DataSourceModelDao {

    List<DataSourceModel> queryAll();

    int insertDataSourceModel(DataSourceModel model);
}
