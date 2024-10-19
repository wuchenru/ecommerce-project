// src/main/java/com/ecommerce/ecommerce_backend/controller/UserController.java

package com.ecommerce.ecommerce_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.ecommerce_backend.model.User;
import com.ecommerce.ecommerce_backend.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Only users with ADMIN role can add users via this endpoint
    // @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/addUser")
    public String addUser(
            @RequestParam String name, 
            @RequestParam String email, 
            @RequestParam String password) {
        
        if (userRepository.findByEmail(email) != null) {
            return "User already exists!";
        }

        // Assuming you have a PasswordEncoder bean
        // It's better to delegate this to UserService
        // For simplicity, let's assume password is already encoded

        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        // newUser.setPassword(passwordEncoder.encode(password));
        userRepository.save(newUser);
        return "User registered successfully!";
    }

    @GetMapping("/all")
    // @PreAuthorize("hasRole('ADMIN')")
    public Iterable<User> getAllUsers() {
        System.out.println("Fetch all users from the DB");
        return userRepository.findAll();
    }

	@GetMapping("/test")
    // @PreAuthorize("hasRole('ADMIN')")
    public String test() {
        return "test";
    }

	// @GetMapping("/all")
	// @PreAuthorize("hasRole('ADMIN')")
	// public ResponseEntity<?> getAllUsers() {
	// 	System.out.println("Attempt to fetch all users from the DB");
	// 	return ResponseEntity.ok(userRepository.findAll());
	// }

	// // Exception handling for access denied
	// @ExceptionHandler(AccessDeniedException.class)
	// public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException e) {
	// 	return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied: " + e.getMessage());
	// }
}
