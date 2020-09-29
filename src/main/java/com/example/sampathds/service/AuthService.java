package com.example.sampathds.service;

import com.example.sampathds.dto.RegisterRequest;
import com.example.sampathds.model.User;
import com.example.sampathds.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthService
{
    @Autowired
    private UserRepository userRepository;
    public ResponseEntity signup(RegisterRequest registerRequest)
    {
        User user=new User();
        user.setUserName(registerRequest.getUserName());
        user.setPassword(registerRequest.getPasssword());
        user.setEmail(registerRequest.getEmail());
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);

    }
}
