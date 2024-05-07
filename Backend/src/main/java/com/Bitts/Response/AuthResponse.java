package com.Bitts.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class AuthResponse {
    private String jwt;
    private String message;

    public AuthResponse() {
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getMessage() {
        return message;
    }

    public AuthResponse(String jwt, String message) {
        this.jwt = jwt;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
