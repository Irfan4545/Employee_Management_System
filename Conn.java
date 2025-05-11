//package employee.management.app;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//
//public class Conn {
//    Connection connection;
//    Statement statement;
//
//    public Conn()
//    {
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","system");
//            statement = connection.createStatement();
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
//
//
//
//
package employee.management.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Conn {
    Connection connection;
    Statement statement;

    public Conn() {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection with the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "system");

            // Create statement allowing scrollable result sets
            statement = connection.createStatement(
                    java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, // Allows forward and backward scrolling
                    java.sql.ResultSet.CONCUR_READ_ONLY        // The result set is read-only
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to close the connection and statement properly (best practice)
    public void closeConnection() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
