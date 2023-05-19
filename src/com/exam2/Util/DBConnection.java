package com.exam2.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        Connection connect = null;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            connect =  DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=EXAM2", "sa", "12345678");

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return connect;
    }
}
