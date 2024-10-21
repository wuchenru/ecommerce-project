package com.ecommerce.ecommerce_backend.config;

import com.ecommerce.ecommerce_backend.filter.JwtAuthenticationFilter;
import com.ecommerce.ecommerce_backend.service.CustomUserDetailsService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletResponse; // Import statement

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableMethodSecurity // Enables method-level security (e.g., @PreAuthorize)
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    // Define the password encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // // Define the CORS configuration
    // @Bean
    // public CorsConfigurationSource corsConfigurationSource() {
    //     CorsConfiguration configuration = new CorsConfiguration();
    //     configuration.setAllowedOrigins(List.of("*")); // Set your allowed origins
    //     configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    //     configuration.setAllowCredentials(true);
    //     configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
        
    //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    //     source.registerCorsConfiguration("/**", configuration);
    //     return source;
    // }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3000")); // Set your allowed origins
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    // // Define the security filter chain
    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http
    //         .cors() // Enable CORS
    //             .and()
    //         .csrf().disable() // Disable CSRF for REST APIs
    //         .sessionManagement()
    //             .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No session will be created or used by Spring Security
    //             .and()
    //         .authorizeHttpRequests()
    //             .requestMatchers("/api/auth/**", "/products/all", "/users/all", "/users/addUser", "/products/test", "/users/login").permitAll() // Public endpoints
    //             .anyRequest().authenticated() // All other endpoints require authentication
    //             .and()
    //         .exceptionHandling()
    //             .authenticationEntryPoint((request, response, authException) -> {
    //                 // Log the authentication exception
    //                 logger.error("Unauthorized access attempt: {}", authException.getMessage());
    //                 response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    //             })
    //             .accessDeniedHandler((request, response, accessDeniedException) -> {
    //                 // Log the access denied exception
    //                 logger.error("Access denied: {}", accessDeniedException.getMessage());
    //                 response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
    //             });

    //     // Add JWT filter
    //     http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    //     return http.build();
    // }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors() // Enable CORS
                .and()
            .csrf().disable() // Disable CSRF for REST APIs
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No session will be created or used by Spring Security
                .and()
            .authorizeHttpRequests()
                .anyRequest().permitAll() // Allow all requests by default
                .and()
            .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> {
                    // Log the authentication exception
                    logger.error("Unauthorized access attempt: {}", authException.getMessage());
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                })
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    // Log the access denied exception
                    logger.error("Access denied: {}", accessDeniedException.getMessage());
                    response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
                });
    
        // Add JWT filter
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    
        return http.build();
    }
}
