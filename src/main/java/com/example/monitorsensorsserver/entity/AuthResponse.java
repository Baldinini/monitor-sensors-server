package com.example.monitorsensorsserver.entity;

public class AuthResponse {

    private final String jwt;
    private String userStatus;

    public AuthResponse(String jwt) {

        this.jwt = jwt;
    }

    public String getJwt() {

        return jwt;
    }
}
