package com.ex.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "data_source_model")
public class DataSourceModel {

    @Id
    private String id;

    private String dsid;

    private String dsType;
    private String dsName;

    private String username;

    private String password;

    private String url;

    private String driverClassName;

    private String creator;

    private String updator;


    private Date createTime;

    private Date updateTime;


}
