package com.example.sampathds.service;

import com.example.sampathds.dto.LoginRequest;
import com.example.sampathds.dto.RegisterRequest;
import com.example.sampathds.model.User;
import com.example.sampathds.repository.UserRepository;
import com.example.sampathds.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtProvider jwtProvider;

    public void signup(RegisterRequest registerRequest)
    {
        com.example.sampathds.model.User user=new User();

        //user.setUserName(registerRequest.getUserName());
        user.setUserName(registerRequest.getUserName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(encodePassword(registerRequest.getPassword()));

        userRepository.save(user);
        //return new ResponseEntity(HttpStatus.OK);

    }
    private String encodePassword(String password)
    {
        return passwordEncoder.encode(password);
    }

     public AuthenticationResponse login(LoginRequest loginRequest)
    {
        Authentication authenticate =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),
                loginRequest.getPassWord()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String authenticationToken =jwtProvider.generateTokrn(authenticate);
        return new AuthenticationResponse(authenticationToken,loginRequest.getUserName());

    }
    public Optional<org.springframework.security.core.userdetails.User> getCurrentUser(){
        org.springframework.security.core.userdetails.User principal =(org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);

    }
}
