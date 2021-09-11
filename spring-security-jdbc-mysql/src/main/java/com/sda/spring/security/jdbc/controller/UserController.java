package com.sda.spring.security.jdbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @GetMapping("/principal")
    public Principal retrievePrincipal(Principal principal) {
        return principal;
    }
}
