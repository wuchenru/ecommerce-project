// src/main/java/com/ecommerce/ecommerce_backend/service/CustomUserDetailsService.java

package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.model.User;
import com.ecommerce.ecommerce_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                getAuthorities(user)
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        return user.getRoles().stream()
                   .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                   .collect(Collectors.toList());
    }

    // Optionally, you can add a method to load user by ID if needed
    public UserDetails loadUserById(Integer id) {
        User user = userRepository.findById(id)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                getAuthorities(user)
        );
    }
}
