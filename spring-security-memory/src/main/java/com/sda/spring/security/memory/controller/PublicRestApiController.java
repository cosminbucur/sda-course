package com.sda.spring.security.memory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PublicRestApiController {

    @GetMapping("/admin")
    public String roleAdmin() {
        return "accessible by admin roles only";
    }

    @GetMapping("/all")
    public String roleAll() {
        return "accessible by admin and user roles";
    }

}
