package com.dailycodework.ilibrary.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


/**
 * @author Samson Effes
 */
@Configuration
@EnableWebSecurity
public class LibrarySecurityConfig {

    private static final String[] SECURED_URLs = {"/books/**"};

    private static final String[] UN_SECURED_URLs = {
            "/books/all",
            "/books/book/{id}",
            "/users/**",
            "/authenticate/**"
    };

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(UN_SECURED_URLs).permitAll().and()
                .authorizeHttpRequests().requestMatchers(SECURED_URLs)
                .hasAuthority("ADMIN").anyRequest().authenticated()
                .and().httpBasic().and()
                .build();
    }

}
