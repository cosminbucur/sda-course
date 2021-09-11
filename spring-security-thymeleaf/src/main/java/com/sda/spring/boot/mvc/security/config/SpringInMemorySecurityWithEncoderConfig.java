package com.sda.spring.boot.mvc.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SpringInMemorySecurityWithEncoderConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()

            .withUser("admin")
            .password(passwordEncoder().encode("pass"))
            .authorities("ROLE_ADMIN", "ACCESS_TEST1", "ACCESS_TEST2")

            .and()
            .withUser("user")
            .password(passwordEncoder().encode("pass"))
            .roles("USER")

            .and()
            .withUser("manager")
            .password(passwordEncoder().encode("pass"))
            .authorities("ROLE_MANAGER", "ACCESS_TEST1");
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
//            .and()
//            .httpBasic(); // Use Basic authentication
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/index.html").permitAll()
            .antMatchers("/home.html").authenticated()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")

            // public endpoints
            .antMatchers("/api/public/test1").permitAll()
            .antMatchers("/api/public/test2").permitAll()

            .and()
            .httpBasic(); // Use Basic authentication
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
