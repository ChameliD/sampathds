package com.newsampath.driving.school.controller;

import com.newsampath.driving.school.dto.LoginRequest;
import com.newsampath.driving.school.dto.RegisterRequest;
import com.newsampath.driving.school.service.AuthService;
import com.newsampath.driving.school.service.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="http://localhost:4200/",maxAge = 3600L)

public class AuthController
{
    @Autowired
    private AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity signup (@RequestBody RegisterRequest registerRequest)
    {
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);

    }
    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest)
    {
        return authService.login(loginRequest);
    }

}
