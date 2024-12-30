package com.ex.utils;

import com.ex.entity.DataSourceModel;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {

//    private static String driver = "com.mysql.cj.jdbc.Driver";
//    private static String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
//    private static String username = "root";
//    private static String password = "Aa+123456";


    private static String driver = "";
    private static String url = "";
    private static String username = "";
    private static String password = "";

    static {
        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
            driver=properties.getProperty("driver");
            url=properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");
            Class.forName(driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static Connection getConnection(){
        Connection connection=null;
        try {
             connection = DriverManager.getConnection(url, username, password);
           return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static  void release(Connection connection, Statement st, ResultSet resultSet){

        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                resultSet = null;
            }
        }

        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                st=null;
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                connection=null;
            }
        }



    }

    public  static List<DataSourceModel> getDataModelList() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String sql = "select * from data_source_model";
        ResultSet resultSet = statement.executeQuery(sql);
        List<DataSourceModel> list = new ArrayList<DataSourceModel>();
        while (resultSet.next()) {
            DataSourceModel dataSourceModel = new DataSourceModel();
            String id = resultSet.getString("id");
            String dsid = resultSet.getString("dsid");
            String dsType = resultSet.getString("ds_type");
            String dsName = resultSet.getString("ds_name");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String url = resultSet.getString("url");
            String driver_class_name = resultSet.getString("driver_class_name");
            String creator = resultSet.getString("creator");
            String updator = resultSet.getString("updator");
            Date createTime = resultSet.getDate("create_time");
            Date updateTime = resultSet.getDate("update_time");

            dataSourceModel.setId(id);
            dataSourceModel.setDsid(dsid);
            dataSourceModel.setDsType(dsType);
            dataSourceModel.setDsName(dsName);
            dataSourceModel.setUsername(username);
            dataSourceModel.setPassword(password);
            dataSourceModel.setUrl(url);
            dataSourceModel.setCreator(creator);
            dataSourceModel.setUpdator(updator);
            dataSourceModel.setCreateTime(createTime);
            dataSourceModel.setUpdateTime(updateTime);
            list.add(dataSourceModel);
        }
        return list;
    }


    public static void main(String[] args) throws SQLException {
        List<DataSourceModel> dataModelList = getDataModelList();
    }

}
