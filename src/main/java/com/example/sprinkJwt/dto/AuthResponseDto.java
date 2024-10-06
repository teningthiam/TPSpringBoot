package com.example.sprinkJwt.dto;

public class AuthResponseDto {

    private String accessToken; // Le token d'accès JWT
    private String tokenType = "Bearer"; // Type de token

    // Constructeur avec paramètres
    public AuthResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }

    // Getters et Setters
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
