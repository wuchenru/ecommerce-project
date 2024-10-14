// // src/main/java/com/ecommerce/ecommerce_backend/config/SecurityConfig.java
// package com.ecommerce.ecommerce_backend.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//             .csrf().disable() // Disable CSRF for simplicity, enable it in a production setting.
//             .authorizeRequests()
//                 .antMatchers("/products/all", "/", "/home").permitAll() // Allow public access
//                 .anyRequest().authenticated() // Require authentication for all other endpoints
//             .and()
//             .formLogin() // Enables default login form
//                 .loginPage("/login").permitAll()
//             .and()
//             .logout()
//                 .permitAll();
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }
// // src/main/java/com/ecommerce/ecommerce_backend/config/SecurityConfig.java

// package com.ecommerce.ecommerce_backend.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// public class SecurityConfig {

//     /**
//      * Defines the PasswordEncoder bean to be used for encoding passwords.
//      * BCrypt is a strong hashing function recommended for password encoding.
//      *
//      * @return a BCryptPasswordEncoder instance
//      */
//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     // add additional security configurations here if needed.
// }
