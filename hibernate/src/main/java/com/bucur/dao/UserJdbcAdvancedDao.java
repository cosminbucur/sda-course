package com.bucur.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserJdbcAdvancedDao implements UserDao {

    public static final String URL = "jdbc:mysql://localhost:3306/hibernate?serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    private static final Logger logger = Logger.getLogger(UserJdbcAdvancedDao.class.getName());

    public void create(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // create connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // create statement
            String sql = "INSERT INTO user(name, email, password) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            // execute
            statement.executeUpdate();

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
             PreparedStatement statement = connection.prepareStatement(sql);
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
        String sql = "SELECT * FROM user WHERE id = ?";

        User result = null;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            statement.setLong(1, id);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                logger.info(id + ", " + name + ", " + email + ", " + password);

                result = new User(name, email, password);
                result.setId(id);
                logger.info("found user" + result);
            }
        } catch (SQLException e) {
            logger.severe("failed to update");
        }
        return result;
    }

    public void update(Long id, User userData) {
        String sql = "UPDATE user SET name = ?, email = ?, password = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, userData.getName());
            statement.setString(2, userData.getEmail());
            statement.setString(3, userData.getPassword());
            statement.setLong(4, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("failed to update");
        }
    }

    public void delete(Long id) {
        String sql = "DELETE FROM user WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            logger.severe("failed to delete");
        }
    }

    @Override
    public void deleteAll() {
        String sql = "DELETE FROM user";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.execute(sql);
        } catch (SQLException e) {
            logger.severe("failed to delete");
        }
    }
}
