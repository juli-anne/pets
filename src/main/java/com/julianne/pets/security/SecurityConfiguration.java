package com.julianne.pets.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService() {

            UserDetails admin = User
                    .withUsername("admin")
                    .authorities("basic", "special")
                    .roles("superuser")
                    .password(passwordEncoder().encode("1")) // can't be raw text, so we encode it
                    .build();

            UserDetails user = User
                    .withUsername("user")
                    .authorities("basic")
                    .roles("basicuser")
                    .password(passwordEncoder().encode("2"))
                    .build();

            return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                // allows post, put, delete mappings with authentication
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> {
                    authorize.anyRequest().authenticated();
//                    authorize.requestMatchers("/open").permitAll();
//                    authorize.requestMatchers("/closed").authenticated();
//                    authorize.requestMatchers(HttpMethod.POST, "/add").authenticated(); // csrf
//
//                    authorize.requestMatchers(HttpMethod.GET, "/special").hasAuthority("special");
//                    authorize.requestMatchers(HttpMethod.GET, "/basic").hasAuthority("basic");
                })
                .httpBasic(Customizer.withDefaults()) // for basic authentication
                .build();
    }
}
