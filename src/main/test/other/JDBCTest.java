package other;

import java.sql.*;

/**
 * @author FaceFeel
 * @Created 2018-01-21 19:34
 */

public class JDBCTest {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class<?> aClass = Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
        PreparedStatement pre = connection.prepareStatement("SELECT * FROM student");
        ResultSet resultSet = pre.executeQuery();
        while (resultSet.next()){
            String string = resultSet.getString(1);
            System.err.println(string);
        }
    }
}
