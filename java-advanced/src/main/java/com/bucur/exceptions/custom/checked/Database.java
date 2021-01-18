package com.bucur.exceptions.custom.checked;

public class Database {

    public void openConnection(String url) throws DatabaseConnectionException {
        if (url.isEmpty() || url.isBlank()) {
            throw new DatabaseConnectionException("failed to open connection with empty url");
        }
    }

    public void save(String object) {
        System.out.println(object + " saved!");
    }
}
