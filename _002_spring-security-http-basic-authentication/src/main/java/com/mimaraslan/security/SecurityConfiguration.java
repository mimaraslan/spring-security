package com.mimaraslan.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        	.inMemoryAuthentication()
        	//.withUser("admin").password("123").roles("ADMIN")
        	.withUser("admin").password(passwordEncoder().encode("123456789")).roles("ADMIN")
        	.and()
        	.withUser("katerina").password(passwordEncoder().encode("123456789")).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
             .authorizeRequests()
             .anyRequest().authenticated()
             .and()
             .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}