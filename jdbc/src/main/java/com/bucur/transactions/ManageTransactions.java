package com.bucur.transactions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManageTransactions {

    String url = "jdbc:mysql://localhost:3306/jdbc_tutorial?serverTimezone=UTC";
    String user = "root";
    String pass = "root";

    public void insertOperation() {
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            if (connection != null) {
                // go to manual mode
                connection.setAutoCommit(false);

                PreparedStatement statement = connection.prepareStatement("INSERT into employees values(?,?,?)");
                statement.setInt(1, 1);
                statement.setString(2, "snow");
                statement.setInt(3, 2000);

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                while (true) {

                    System.out.println("enter id");
                    String input1 = br.readLine();
                    int id = Integer.parseInt(input1);

                    System.out.println("enter name");
                    String name = br.readLine();

                    System.out.println("enter salary");
                    String input3 = br.readLine();
                    int salary = Integer.parseInt(input3);

                    statement.setInt(1, id);
                    statement.setString(2, name);
                    statement.setInt(3, salary);
                    statement.executeUpdate();

                    System.out.println("commit/rollback");
                    String transactionOperation = br.readLine();
                    if (transactionOperation.equals("commit")) {
                        // commit
                        connection.commit();
                    }
                    if (transactionOperation.equals("rollback")) {
                        // rollback
                        connection.rollback();
                    }

                    System.out.println("Want to add more records y/n");
                    String answer = br.readLine();
                    if (answer.equals("n")) {
                        break;
                    }

                }
                // final commit
                connection.commit();
                System.out.println("record successfully saved");

                // before closing connection commit() is called
                connection.close();
                System.out.println("record successfully saved");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
