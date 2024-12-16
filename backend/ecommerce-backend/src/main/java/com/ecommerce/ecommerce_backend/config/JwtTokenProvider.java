// src/main/java/com/ecommerce/ecommerce_backend/config/JwtTokenProvider.java

package com.ecommerce.ecommerce_backend.config;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.ecommerce.ecommerce_backend.service.CustomUserDetailsService;

import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    // Generate JWT token
    public String generateToken(Authentication authentication) {
        org.springframework.security.core.userdetails.User userPrincipal = 
                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername()) // typically email
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    // Get email from JWT
    public String getEmailFromJWT(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(jwtSecret)
                            .parseClaimsJws(token)
                            .getBody();

        return claims.getSubject();
    }

    // Validate JWT token
    public boolean validateToken(String authToken) {
        System.out.println("problem-1");
        try {
            System.out.println("problem0");
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            // Invalid JWT signature
            System.out.println("problem1");
        } catch (MalformedJwtException ex) {
            // Invalid JWT token
            System.out.println("problem2");
        } catch (ExpiredJwtException ex) {
            // Expired JWT token
            System.out.println("problem3");
        } catch (UnsupportedJwtException ex) {
            // Unsupported JWT token
            System.out.println("problem4");
        } catch (IllegalArgumentException ex) {
            // JWT claims string is empty
            System.out.println("problem5");
        }
        return false;
    }
}
