// src/main/java/com/ecommerce/ecommerce_backend/service/UserService.java

package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.model.User;
import com.ecommerce.ecommerce_backend.payload.SignUpRequest;
import com.ecommerce.ecommerce_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(SignUpRequest signUpRequest) {
        User user = new User();
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.getRoles().add("USER"); // Assign default role
        return userRepository.save(user);
    }

    public boolean existsByEmail(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
