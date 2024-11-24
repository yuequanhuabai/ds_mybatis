package com.ex.util;

import com.ex.entity.DataSourceModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {

    public static final String URL = "jdbc:mysql://localhost:3306/test?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&characterSetResults=utf8&useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Aa+123456";
    public static final String SQL = "select * from data_source_model";

    public static Connection conn = null;

    public static Statement statement = null;

    public static ResultSet resultSet = null;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // query
        List<DataSourceModel> queryResults = getQueryResults();
        System.out.println(queryResults);
    }

    public static List<DataSourceModel> getQueryResults() throws ClassNotFoundException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");

        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        statement = conn.createStatement();

        resultSet = statement.executeQuery(SQL);
        List<DataSourceModel> models = new ArrayList<>();
        while (resultSet.next()) {
            DataSourceModel model = new DataSourceModel();
            model.setDsid(resultSet.getString(1));
            model.setDsType(resultSet.getString(2));
            model.setDsName(resultSet.getString(3));
            model.setUsername(resultSet.getString(4));
            model.setPassword(resultSet.getString(5));
            model.setUrl(resultSet.getString(6));
            model.setDriverClassName(resultSet.getString(7));
            model.setCreator(resultSet.getString(8));
            model.setUpdator(resultSet.getString(9));
            model.setCreateTime(resultSet.getDate(10));
            model.setUpdateTime(resultSet.getDate(11));
            models.add(model);
            System.out.println("========================");

//            System.out.println(resultSet.getString(1));
//            System.out.println(resultSet.getString(2));
//            System.out.println(resultSet.getString(3));
//            System.out.println(resultSet.getString(4));
//            System.out.println(resultSet.getString(5));
//            System.out.println(resultSet.getString(6));
//            System.out.println(resultSet.getString(7));
//            System.out.println(resultSet.getString(8));
//            System.out.println(resultSet.getString(9));
//            System.out.println(resultSet.getDate(10));
//            System.out.println(resultSet.getDate(11));

        }
        return models;
    }
}
