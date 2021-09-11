package com.sda.spring.boot.mvc.security.config;

import com.sda.spring.boot.mvc.security.dbauth.AppUser;
import com.sda.spring.boot.mvc.security.dbauth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DbInit implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        AppUser appUser = new AppUser("admin", "pass", "USER", "");
        userRepository.save(appUser);
    }
}
