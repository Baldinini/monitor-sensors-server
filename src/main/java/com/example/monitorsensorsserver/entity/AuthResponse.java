package com.example.monitorsensorsserver.entity;

public class AuthResponse {

    private final String jwt;

    public String getUserStatus() {
        return userStatus;
    }

    private final String userStatus;

    public AuthResponse(String jwt, String userStatus) {

        this.jwt = jwt;
        this.userStatus = userStatus;
    }

    public String getJwt() {

        return jwt;
    }
}
