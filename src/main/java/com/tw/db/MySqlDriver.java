package com.tw.db;

import java.sql.*;

public class MySqlDriver {
    public static final String URL = "jdbc:mysql://localhost:3306/db1";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver load error");
        }

        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String sex = resultSet.getString("sex");
                System.out.println("id = " + id + " name = " + name + " age = " + age + " sex = " + sex);
            }
        } catch (SQLException e) {
            System.out.println("Connect error");
            e.printStackTrace();
        }
    }
}
