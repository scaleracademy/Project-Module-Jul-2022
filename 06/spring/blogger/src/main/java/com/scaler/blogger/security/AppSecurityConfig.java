package com.scaler.blogger.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JWTAuthenticationFilter jwtAuthenticationFilter;
    @Autowired
    private JWTAuthManager jwtAuthManager;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()

                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/users", "/users/login").permitAll()
                .antMatchers(HttpMethod.GET, "/articles").permitAll()
                .anyRequest().authenticated()

                .and()
                .addFilterBefore(jwtAuthenticationFilter, AnonymousAuthenticationFilter.class);
    }

    @Override
    protected JWTAuthManager authenticationManager() throws Exception {
        return jwtAuthManager;
    }
}
