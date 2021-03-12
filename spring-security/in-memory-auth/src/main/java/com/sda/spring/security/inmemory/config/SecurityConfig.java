package com.sda.spring.security.inmemory.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("admin")
            //{noop} makes sure that the password encoder doesn't do anything
            .password("{noop}pass")
            .roles("ADMIN") // Role of the user
            .authorities("READ_PRIVILEGE", "WRITE_PRIVILEGE")
            .and()
            .withUser("user")
            .password("{noop}pass")
            .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest()
            .hasAnyRole("ADMIN", "USER")
            .and()
            // use basic authentication
            .httpBasic()
            .and()
            // logout functionality
            .logout();
    }

}
