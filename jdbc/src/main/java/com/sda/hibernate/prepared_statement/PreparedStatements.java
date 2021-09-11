package com.bucur.prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatements {

    String url = "jdbc:mysql://localhost:3306/jdbc_tutorial?serverTimezone=UTC";
    String user = "root";
    String pass = "root";

    public void insertOperation(String name, String email, String country) {
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            if (connection != null) {
                // INSERT
                PreparedStatement statement = connection.prepareStatement("INSERT user(name, email, country) VALUES " +
                    "('" + name + "', '" + email + "', '" + country + "')'");
                statement.setString(1, name);
                statement.setString(2, email);
                statement.setString(3, country);
                int result = statement.executeUpdate();
                System.out.println("Insert return: " + (result == 1 ? "OK" : "ERROR"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOperation(int id, String name, String email, String country) {
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            if (connection != null) {
                // UPDATE
                PreparedStatement statement = connection.prepareStatement("UPDATE user SET name = '" + name + "', " +
                    "email = '" + email + "', country = '" + country + "' WHERE id = " + id);
                statement.setString(1, name);
                statement.setString(2, email);
                statement.setString(3, country);
                statement.setInt(4, id);
                int result = statement.executeUpdate();
                System.out.println("Update return: " + (result == 1 ? "OK" : "ERROR"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOperation(int id) {
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            if (connection != null) {
                // DELETE
                PreparedStatement statement = connection.prepareStatement("DELETE FROM user WHERE id = " + id);
                statement.setInt(1, id);
                int result = statement.executeUpdate();
                System.out.println("Delete return: " + (result == 1 ? "OK" : "ERROR"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
