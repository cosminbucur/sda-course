package com.sda.patterns.grasp.expert;

public class Controller {

    private AuthenticationModule authenticationModule;

    public Controller(AuthenticationModule authenticationModule) {
        this.authenticationModule = authenticationModule;
    }

    public void authenticateUser(LoginRequest loginRequest) {
        authenticationModule.authenticate(loginRequest);
    }


}
