package com.sda.spring.security.jpa.repository;

import com.sda.spring.security.jpa.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
