package com.example.rottentomatoforgames.model.request;

public class LoginRequest {
    private String emailAddress;
    private String password;
    public LoginRequest() {
    }

    public LoginRequest(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }



}
