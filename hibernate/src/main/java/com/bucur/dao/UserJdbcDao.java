package com.bucur.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserJdbcDao implements UserDao {

    public static final String URL = "jdbc:mysql://localhost:3306/hibernate?serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    private static final Logger logger = Logger.getLogger(UserJdbcDao.class.getName());

    public void create(User user) {
        Connection connection = null;
        Statement statement = null;
        try {
            // create connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // create statement
            statement = connection.createStatement();
            String sql = "INSERT INTO user(name, email, password) VALUES "
                + "('" + user.getName() + "','" + user.getEmail() + "','" + user.getPassword() + "')";

            // execute
            statement.execute(sql);

            // * process response (if needed)
        } catch (SQLException e) {
            // handle jdbc exceptions
            logger.severe("failed to create user");
        } catch (Exception e) {
            // handle other exceptions
            logger.severe("something went wrong");
        } finally {
            // close resources
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                logger.severe("failed to close statement");
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.severe("failed to close connection");
            }
        }
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM user";

        List<User> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            // iterate result set and get all values
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                logger.info(id + ", " + name + ", " + email + ", " + password);

                User user = new User(name, email, password);
                user.setId(id);
                logger.info(user.toString());
                result.add(user);
            }
        } catch (SQLException e) {
            logger.severe("failed to update");
        }

        return result;
    }

    public User findById(Long id) {
        String sql = "SELECT * FROM user WHERE id = " + id;

        User result = null;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                logger.info(id + ", " + name + ", " + email + ", " + password);

                result = new User(name, email, password);
                result.setId(id);
                logger.info("found user " + result);
            }
        } catch (SQLException e) {
            logger.severe("failed to update");
        }
        return result;
    }

    public void update(Long id, User userData) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "UPDATE user SET name = '" + userData.getName() + "', " +
                "email = '" + userData.getEmail() + "', " +
                "password = '" + userData.getPassword() +
                "' WHERE id = " + id;

            statement.executeUpdate(sql);
        } catch (SQLException e) {
            logger.severe("failed to update");
        }
    }

    public void delete(Long id) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "DELETE FROM user WHERE id = " + id;

            statement.execute(sql);
        } catch (SQLException e) {
            logger.severe("failed to delete");
        }
    }

    @Override
    public void deleteAll() {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "DELETE FROM user";

            statement.execute(sql);
        } catch (SQLException e) {
            logger.severe("failed to delete");
        }
    }
}
