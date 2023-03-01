package com.campusVirtual.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) 
public class SecurityConfig {
    
 
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http){
       
        try {
            return http
                        //.csrf().disable()
                        .authorizeRequests()
                        .antMatchers(HttpMethod.GET, "/v1/**").permitAll()
                        .anyRequest()
                        .authenticated()
                        .and()
                        .httpBasic() 
                        .and()
                        .build();
                                 

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
