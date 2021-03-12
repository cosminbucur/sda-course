package com.sda.spring.security.inmemory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public")
public class PublicRestApiController {

    @GetMapping("role-admin")
    public String roleAdmin() {
        return "accessible by admin roles only";
    }

    @GetMapping("role-all")
    public String roleAll() {
        return "accessible by admin and user roles";
    }

}
