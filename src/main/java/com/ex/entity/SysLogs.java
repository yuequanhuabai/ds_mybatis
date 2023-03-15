package com.ex.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SysLogs {
    private String id;
    private String username;
    private String operation;
    private String method;
    private long time;
    private String ip;
    private Date createTime;
    private String params;

}