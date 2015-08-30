package com.tw.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleJDBC {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:oracle:thin:@ssessdevdb:1521:devdb1";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("error");
            return;
        }

        try {
            Connection connection = DriverManager.getConnection(url, "auto_test", "auto_test");

            if (connection != null) {
                System.out.println("success");
            }
        } catch (Exception e) {
            System.out.println("connection error");
        }
    }
}
