package com.example.mvpapp.model.signuprequest;

public class SignUpRequest {

    String email, name, password, loginType;

    public SignUpRequest(String email, String name, String password, String loginType) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.loginType = loginType;
    }
}
