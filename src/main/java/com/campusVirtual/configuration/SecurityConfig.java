package com.campusVirtual.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.campusVirtual.security.jwtFilter.JwtRequestFilter;
import com.campusVirtual.security.userPasswordFilter.UserPasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    

    private final UserDetailsService miUserDetailsService;
    @Autowired
    private PasswordEncoder passwordeEncoder;
   
    
    public SecurityConfig( 
        UserDetailsService miUserDetailsService
        /*PasswordEncoder passwordeEncoder*/){
            this.miUserDetailsService=miUserDetailsService;
            //this.passwordeEncoder=passwordeEncoder;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http,AuthenticationManager authManager)throws Exception{
       UserPasswordAuthenticationFilter userPasswordAuthenticationFilter = new UserPasswordAuthenticationFilter();
       userPasswordAuthenticationFilter.setAuthenticationManager(authManager);
       userPasswordAuthenticationFilter.setFilterProcessesUrl(
        "/v1/auth/login");
            return http
                        .csrf().disable().cors()
                        //.and() .headers().contentTypeOptions().disable()
                        .and().authorizeRequests().antMatchers(HttpMethod.POST, "/v1/auth/register").permitAll()
                        .and()
                        .authorizeRequests().antMatchers("/swagger-ui.html/",
                        "/v3/api-docs/","/v3/api-docs/**", "/v3/api-docs.yaml","/swagger-ui/**"
                        ).permitAll()
                        .and()
                        .authorizeRequests().antMatchers("/v1/admin/**").hasAuthority("ROLE_ADMIN")
                        .and()
                        .authorizeRequests().anyRequest().authenticated()
                        .and()
                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and()
                        .addFilter(userPasswordAuthenticationFilter)
                        .addFilterBefore(new JwtRequestFilter(), UsernamePasswordAuthenticationFilter.class)
                        .build();

    }

    @Bean 
    AuthenticationManager authManager(HttpSecurity http)throws Exception{
        return http
            .getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(miUserDetailsService)
            .passwordEncoder(passwordeEncoder)
            .and()
            .build();

    }

   
}
/*  posible swagger config
"/swagger-ui/index.html/swagger-ui.css/",
"/swagger-ui/swagger-ui.css?v=3.0.0.css/",
"/swagger-ui/springfox.css?v=3.0.0/",
"/swagger-ui/index.html/swagger-ui.css?v=3.0.0",
/* "/api/swagger-ui/**",
"/v3/**","/swagger-ui/index.html/**","/swagger-resources/**",
"/swagger-ui.html","/webjars/**","/swagger.json",
"/swagger-ui/index.html/*" 
----------------------------
"/swagger-ui.html" <-- for UI
"/swagger-ui/**" <-- for UI redirects
"/v3/api-docs/**" <-- for json docs and openapi configuration
"/v3/api-docs.yaml" <-- for yaml docs
*/