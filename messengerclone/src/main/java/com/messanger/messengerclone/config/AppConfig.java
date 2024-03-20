package com.messanger.messengerclone.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;


import java.util.Arrays;
import java.util.Collections;

@Configuration
public class AppConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeHttpRequests(authorize->authorize.requestMatchers("/api/**").authenticated()
                        .anyRequest().permitAll()
                ).addFilterBefore(null, null).csrf().disable()
                .cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {

                        CorsConfiguration cfg=new CorsConfiguration();
                        cfg.setAllowedOrigins(Arrays.asList(
//                        "urlOfFontEnd"
                        ));
                        cfg.setAllowedMethods(Collections.singletonList("*"));
                        


                        return null;
                    }
                })
                .and().formLogin().and().httpBasic();
        return http.build();
    }
    
}
