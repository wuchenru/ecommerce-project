// src/main/java/com/ecommerce/ecommerce_backend/payload/SignUpRequest.java

package com.ecommerce.ecommerce_backend.payload;

import jakarta.validation.constraints.*;

public class SignUpRequest {
    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, message = "Password should have at least 6 characters")
    private String password;

    // Getters and Setters

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
        
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
        
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
