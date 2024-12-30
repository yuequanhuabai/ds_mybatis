package com.ex.repository;

import com.ex.entity.DataSourceModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataSourceConfigRepository extends JpaRepository<DataSourceModel,Long> {

    List<DataSourceModel> findAll();
}
