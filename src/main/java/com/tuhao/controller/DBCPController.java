package com.tuhao.controller;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * @autor FaceFeel
 * @create 2017-10-14 17:03
 */

public class DBCPController {

    public static void main(String[] args) throws SQLException {

        long begin = System.currentTimeMillis();
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();

        DatabaseMetaData metaData = connection.getMetaData();
        String driverName = metaData.getDriverName();
        String url = metaData.getURL();
        String userName = metaData.getUserName();

        int defaultTransactionIsolation = metaData.getDefaultTransactionIsolation();


        System.out.println("dirver:"+driverName+"  "+"url:"+url+"  "+"userName:"+userName);
        connection.close();
        long end = System.currentTimeMillis();
        System.err.println("总共花了多少时间：" + (end - begin) / 1000 + "秒");
    }

//    public static void main(String args[]) throws Exception {
//
//        long begin = System.currentTimeMillis();
//            BasicDataSourceFactory factory = new BasicDataSourceFactory();
//        Properties properties = new Properties();
//        InputStream inputStream = DBCPController.class.getClassLoader().getResourceAsStream("jbdc.properties");
//        properties.load(inputStream);
//        DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
//
//        for (int i = 0; i < 1000000; i++) {
//
//            Connection connection = dataSource.getConnection();
//            if (connection != null) {
//                System.out.println("取得第" + i + "个连接");
//            }
//            assert connection != null;
//            connection.close();
//        }
//        long end = System.currentTimeMillis();
//        System.err.println("总共花了多少时间：" + (end - begin) / 1000 + "秒");
//    }

//    public static void main(String[] args) throws SQLException {
//
//        long begin = System.currentTimeMillis();
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//
//        for (int i = 0; i < 1000000; i++) {
//
//            Connection connection = dataSource.getConnection();
//            if (connection != null) {
//                System.out.println("取得第" + i + "个连接");
//                connection.close();
//            }
//        }
//        long end = System.currentTimeMillis();
//        System.err.println("总共花了多少时间：" + (end - begin) / 1000 + "秒");
//    }
}
