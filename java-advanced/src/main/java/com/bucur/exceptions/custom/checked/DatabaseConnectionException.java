package com.bucur.exceptions.custom.checked;

public class DatabaseConnectionException extends Exception {

    public DatabaseConnectionException(String message) {
        super(message);
    }
}
