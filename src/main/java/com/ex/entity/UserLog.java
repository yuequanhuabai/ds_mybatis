package com.ex.entity;

public class UserLog {

    private String id;

    private String username;

    private String operation;

    private String targetClass;

    private String method;

    private String param;

    private Long start;
    private Long end;
    private Long spend;

    private String ip;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(String targetClass) {
        this.targetClass = targetClass;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return param;
    }

    public void setParam(String params) {
        this.param = params;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public Long getSpend() {
        return spend;
    }

    public void setSpend(Long spend) {
        this.spend = spend;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "UserLog{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", operation='" + operation + '\'' +
                ", targetClass='" + targetClass + '\'' +
                ", method='" + method + '\'' +
                ", params='" + param + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", spend=" + spend +
                ", ip='" + ip + '\'' +
                '}';
    }
}
