package com.messanger.messengerclone.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        
        return http.build();
    }
    
}
