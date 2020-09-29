package com.example.sampathds.controller;

import com.example.sampathds.dto.LoginRequest;
import com.example.sampathds.dto.RegisterRequest;
import com.example.sampathds.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController
{
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public void signup(@RequestBody RegisterRequest registerRequest)
    {
        authService.signup(registerRequest);
    }
    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest)
    {
        authService.login(loginRequest);
    }

}
