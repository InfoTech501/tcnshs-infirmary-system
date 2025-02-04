package com.rocs.medical.records.application.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHelper {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:oracle:thin:@//localhost:1521/ORCLPDB";
        String username = "user_jake";
        String password = "Changeme0";

        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(url, username, password);

    }
}
