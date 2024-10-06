package com.example.sprinkJwt.controller;

import com.example.sprinkJwt.dto.AuthRequestDto;
import com.example.sprinkJwt.dto.UserDto;
import com.example.sprinkJwt.entite.User;
import com.example.sprinkJwt.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * Endpoint for user registration.
     *
     * @param userDto the user data transfer object containing registration info
     * @return ResponseEntity containing the registered User and HTTP status
     */
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody UserDto userDto) {
        User registeredUser = authService.register(userDto);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    /**
     * Endpoint for user login.
     *
     * @param authRequestDto the authentication request data transfer object
     * @return ResponseEntity containing the JWT token if authentication is successful
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody AuthRequestDto authRequestDto) {
        String token = authService.login(authRequestDto);
        return ResponseEntity.ok(token);
    }

    // Optionally, add error handling
    // You can create a global exception handler to manage errors more gracefully
}
