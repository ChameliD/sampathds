package com.example.sampathds.service;

import com.example.sampathds.dto.LoginRequest;
import com.example.sampathds.dto.RegisterRequest;
import com.example.sampathds.model.User;
import com.example.sampathds.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity signup(RegisterRequest registerRequest)
    {
        User user=new User();
        user.setUserName(registerRequest.getUserName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encodePassword(registerRequest.getPasssword()));

        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);

    }
    private String encodePassword(String password)
    {
        return passwordEncoder.encode(password);
    }

    public void login(LoginRequest loginRequest)
    {
        Authentication authenticate =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),
                loginRequest.getPassWord()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
    }
}
