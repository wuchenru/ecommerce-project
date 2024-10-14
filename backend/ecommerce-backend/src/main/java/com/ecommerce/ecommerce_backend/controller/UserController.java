// src/main/java/com/ecommerce/ecommerce_backend/controller/UserController.java

package com.ecommerce.ecommerce_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
// import org.springframework.security.crypto.password.PasswordEncoder;
import com.ecommerce.ecommerce_backend.model.User;
import com.ecommerce.ecommerce_backend.repository.UserRepository;

@RestController // Changed from @Controller to @RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private PasswordEncoder passwordEncoder;

    @PostMapping(path = "/addUser")
    public String addUser(
            @RequestParam String name, 
            @RequestParam String email, 
            @RequestParam String password) {
        
        if (userRepository.findByEmail(email) != null) {
            return "User already exists!";
        }

        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        // newUser.setPassword(passwordEncoder.encode(password));
        userRepository.save(newUser);
        return "User registered successfully!";
    }

    // @PostMapping(path = "/login")
    // public String login(
    //         @RequestParam String email, 
    //         @RequestParam String password) {
        
    //     User user = userRepository.findByEmail(email);
    //     if (user != null && passwordEncoder.matches(password, user.getPassword())) {
    //         return "Login successful!";
    //     } else {
    //         return "Invalid credentials!";
    //     }
    // }

    @GetMapping(path = "/all")
    public Iterable<User> getAllUsers() {
        System.out.println("Fetch all users from the DB");
        return userRepository.findAll();
    }
}
