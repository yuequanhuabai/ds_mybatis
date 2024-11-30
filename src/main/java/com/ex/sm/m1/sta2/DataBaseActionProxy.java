package com.ex.sm.m1.sta2;

public class DataBaseActionProxy implements DataBaseAction{

    DataBaseAction dataBaseAction;
    public DataBaseActionProxy(DataBaseAction dataBaseAction) {
        this.dataBaseAction = dataBaseAction;
    }

    @Override
    public void execute() {
        System.out.println("begin execute");
        dataBaseAction.execute();
        System.out.println("end execute");
    }
}
