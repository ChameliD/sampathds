package com.example.sampathds.security;

import com.example.sampathds.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.Key;

@Service
public class JwtProvider
{
    private Key key;
    @PostConstruct
    public void init()
    {
        key=Keys.secretKeyFor(SignatureAlgorithm.ES512);

    }
    public String generateTokrn(org.springframework.security.core.Authentication authentication)
    {
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUserName())
                .signWith(key)
                .compact();
    }


}
