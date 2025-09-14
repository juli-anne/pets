package com.julianne.pets.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class).build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//            UserDetails admin = User
//                    .withUsername("admin")
//                    .authorities("basic", "special")
//                    .roles("superuser")
//                    .password(passwordEncoder().encode("1")) // can't be raw text, so we encode it
//                    .build();
//
//            UserDetails user = User
//                    .withUsername("user")
//                    .authorities("basic")
//                    .roles("basicuser")
//                    .password(passwordEncoder().encode("2"))
//                    .build();
//
//            return new InMemoryUserDetailsManager(admin, user);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/createuser").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(
                        new BasicAuthenticationFilter(authenticationManager(httpSecurity)),
                        UsernamePasswordAuthenticationFilter.class
                )
                .build();
    }
}
