 package com.mimaraslan.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired 
    private UserPrincipalDetailsService userPrincipalDetailsService;

    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
    }
    
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
        return daoAuthenticationProvider;
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
//        	.inMemoryAuthentication()
//        	
//        	.withUser("admin").password(passwordEncoder().encode("admin"))
//        	.roles("ADMIN")
//        	.authorities("ACCESS_TEST1", "ACCESS_TEST2", "ROLE_ADMIN") 
//        	
//        	.and()
//        	.withUser("katerina").password(passwordEncoder().encode("katerina"))
//        	.roles("USER") 
//        	
//	        .and()
//        	.withUser("manager").password(passwordEncoder().encode("manager"))
//        	//.roles("MANAGER")
//        	.authorities("ACCESS_TEST2","ROLE_MANAGER");    
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
             .authorizeRequests()
             .antMatchers("/index.html").permitAll()
             .antMatchers("/profile/**").authenticated()
             .antMatchers("/admin/**").hasRole("ADMIN")
             .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")           
             .antMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1")
             .antMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
             .antMatchers("/api/public/users").hasRole("ADMIN") 
             .and()
             .httpBasic();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }   
}