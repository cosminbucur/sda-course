package com.sda.patterns.grasp.expert;

public class DemoExpert {

    public static void main(String[] args) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("test");
        loginRequest.setUsername("secret");

        Database database = new Database();
        AuthenticationModule authenticationModule = new AuthenticationModule(database);
        Controller controller = new Controller(authenticationModule);
        controller.authenticateUser(loginRequest);
    }
}
