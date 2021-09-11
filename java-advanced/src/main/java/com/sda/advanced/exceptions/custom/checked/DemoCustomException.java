package com.sda.advanced.exceptions.custom.checked;

public class DemoCustomException {

    public static void main(String[] args) {
        useDatabaseToWrite();
    }

    private static void useDatabaseToWrite() {
        Database database = new Database();

        try {
            database.openConnection("");

            database.save("important object");
        } catch (DatabaseConnectionException e) {
            System.out.println(e.getMessage());
        }
    }
}
