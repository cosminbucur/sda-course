package com.sda.spring.security.jpa.config;

import com.sda.spring.security.jpa.model.AppUser;
import com.sda.spring.security.jpa.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbInit {

    @Autowired
    private AppUserRepository appUserRepository;

    @Bean
    public CommandLineRunner initialData() {
        return args -> {
            AppUser admin = new AppUser("admin", "{bcrypt}$2y$12$92ZkDrGVS3W5ZJI.beRlEuyRCPrIRlkEHz6T.7MVmH38l4/VAHhyi", "ADMIN");
            AppUser user = new AppUser("user", "{bcrypt}$2y$12$92ZkDrGVS3W5ZJI.beRlEuyRCPrIRlkEHz6T.7MVmH38l4/VAHhyi", "USER");
            appUserRepository.save(admin);
            appUserRepository.save(user);
        };
    }
}
