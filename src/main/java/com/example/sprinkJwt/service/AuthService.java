package com.example.sprinkJwt.service;

import com.example.sprinkJwt.dto.AuthRequestDto;
import com.example.sprinkJwt.dto.UserDto;
import com.example.sprinkJwt.entite.User;
import com.example.sprinkJwt.repository.UserRepository;
import com.example.sprinkJwt.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(UserDto userDto) {
        return userService.createUser(userDto); // Création de l'utilisateur directement
    }

    public String login(AuthRequestDto authRequestDto) {
        // Ajout de la logique de connexion
        User user = userService.findByEmail(authRequestDto.getEmail())
                .orElseThrow(() -> new UserNotFoundException("Invalid email or password"));

        if (!passwordEncoder.matches(authRequestDto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        // Logique pour retourner un token JWT
        return "JWT token"; // À remplacer par une vraie génération de token
    }
}
