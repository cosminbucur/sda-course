package com.sda.patterns.grasp.expert;

// this class is an expert in authentication
public class AuthenticationModule {

    private Database database;

    public AuthenticationModule(Database database) {
        this.database = database;
    }

    public void authenticate(LoginRequest loginRequest) {
        // search username in database
        boolean userFound = database.userExists(loginRequest.getUsername());

        // if exists, check password
        if (userFound) {
            // authenticate
        }

        System.out.println("authentication module: authenticating...");
    }
}
