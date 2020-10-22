package com.example.sampathds.service;

import com.example.sampathds.model.User;
import com.example.sampathds.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserDetailsServicelmpl implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
       User user= userRepository.findByUserName(username).orElseThrow(() ->
               new UsernameNotFoundException("No usernfound "+username));
        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(),
                getAuthorities("ROLE_USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role_user)
    {
        return null;
    }
}
