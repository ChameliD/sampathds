package com.example.sampathds.security;

import com.example.sampathds.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

@Service
public class JwtProvider
{
    private KeyStore keyStore;
    @PostConstruct
    public void init()
    {
        try {
            keyStore=KeyStore.getInstance("JKS");
            InputStream resourceAsStream  = getClass().getResourceAsStream("/sampathds.jks");
            keyStore.load(resourceAsStream,"1652796".toCharArray());

        } catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
            throw new sampathdsExseption("Exception occured while loading keyStore");
        }


    }
    public String generateTokrn(Authentication authentication)
    {
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUserName())
                .signWith(getPrivateKey())
                .compact();
    }

    private PrivateKey getPrivateKey() {
        try {
            return (PrivateKey)keyStore.getKey("sampathds","1652796".toCharArray());
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new sampathdsExseption("Exception occured while retrieving public Key keyStore");
        }

    }

    public boolean validateToken(String jwt)
    {
        Jwts.parser().setSigningKey(getPublicKey()).parseClaimsJws(jwt);
        return true;
    }
    private PublicKey getPublicKey(){
        try {
            return keyStore.getCertificate("sampathds").getPublicKey();
        } catch (KeyStoreException e) {
            throw new sampathdsExseption("Exception occured while retrieving public Key keyStore");
        }
    }
    public String getUsernameFromJWT(String token)
    {
        Claims claims = Jwts.parser()
                .setSigningKey(getPublicKey())
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
