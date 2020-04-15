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
        	
        	.withUser("admin").password(passwordEncoder().encode("admin"))
        	//.roles("ADMIN")
        	.authorities("ACCESS_TEST1", "ACCESS_TEST2", "ROLE_ADMIN") // Permission Authorization
        	
        	.and()
        	.withUser("katerina").password(passwordEncoder().encode("katerina"))
        	.roles("USER") 
        	
	        .and()
        	.withUser("manager").password(passwordEncoder().encode("manager"))
        	//.roles("MANAGER")
        	.authorities("ACCESS_TEST2", "ROLE_MANAGER"); // Permission Authorization
        
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
             .authorizeRequests()
             .antMatchers("/index.html").permitAll()
             .antMatchers("/profile/**").authenticated()
             .antMatchers("/admin/**").hasRole("ADMIN")
             .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
             // .antMatchers("/management/**").access("hasRole('ADMIN') or hasRole('MANAGER')")

             // http://localhost:8443/api/public/test1
             .antMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1")
             .antMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
             .and()
             .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}