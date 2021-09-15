package com.sda.patterns.design.creational.singleton.ex_singleton;

public class Database {

    private static Database databaseInstance;
    private String driverClassName = "oracle";
    private String url = "jdbc:oracle:thin:@myhost:1521:orcl";
    private String username = "admin";
    private String password = "secret";

    private Database() {
    }

    public static synchronized Database getDatabaseInstance() {
        if (databaseInstance == null) {
            databaseInstance = new Database();
        }
        return databaseInstance;
    }

    public void connect() {
        System.out.println("database opened");
    }

    public void query() {
        System.out.println("find my heroes");
    }

    public void disconnect() {
        System.out.println("database closed");
    }

}
