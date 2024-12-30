package com.ex.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DataSourceModel {

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
