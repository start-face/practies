package com.tuhao.tool;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @autor FaceFeel
 * @create 2017-10-14 17:41
 */

public class MysqlPool {

    public static Connection getConnection() {

        Connection connection =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeCon(Connection connection){

        try {
            if(connection != null){
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
