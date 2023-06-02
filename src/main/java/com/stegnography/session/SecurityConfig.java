//package com.stegnography.session;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers( "/userlogin","/user").permitAll() // Allow access to the login page
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/userlogin") // Specify the login page URL
//                .defaultSuccessUrl("/") // Specify the default success URL after login
//                .and()
//                .logout()
//                .logoutSuccessUrl("/userlogin") // Specify the logout success URL
//                .and()
//                .sessionManagement()
//                .maximumSessions(1) // Allow only one session per user
//                .expiredUrl("/userlogin"); // Specify the URL to redirect when a session expires
//    }
//}
//
