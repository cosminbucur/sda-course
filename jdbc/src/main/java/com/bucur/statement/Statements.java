package com.bucur.statement;

import java.sql.*;

public class Statements {

    String url = "jdbc:mysql://localhost:3306/jdbc_tutorial?serverTimezone=UTC";
    String user = "root";
    String pass = "root";

    public void queryOperation() {
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, name, email, country FROM user");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                System.out.println(id + ", " + name + ", " + email + ", " + country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOperation(String name, String email, String country) {
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            if (statement != null) {
                // INSERT
                int result = statement.executeUpdate("INSERT user(name, email, country) VALUES " +
                    "('" + name + "', '" + email + "', '" + country + "')'");
                System.out.println("Insert return: " + (result == 1 ? "OK" : "ERROR"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOperation(int id, String name, String email, String country) {
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            if (statement != null) {
                // UPDATE
                int result = statement.executeUpdate("UPDATE user SET name = '" + name + "', " +
                    "email = '" + email + "', country = '" + country + "' WHERE id = " + id);
                System.out.println("Update return: " + (result == 1 ? "OK" : "ERROR"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOperation(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            if (statement != null) {
                // DELETE
                int result = statement.executeUpdate("DELETE FROM user WHERE id = " + id);
                System.out.println("Delete return: " + (result == 1 ? "OK" : "ERROR"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
