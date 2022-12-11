package org.afrivera.movie.auth.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.SignatureException;
import java.util.Date;

@Component
public class JWTUtil {

    @Value("${app.jwt-secret}")
    private String ACCESS_TOKEN_SECRET;

    @Value("${app.jwt-expiration-milliseconds}")
    private int ACCESS_TOKEN_VALIDITY_SECONDS;

    // method to generate token
    public String generateJWTToken(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Date expirationDate = new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS);

        String token = Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, ACCESS_TOKEN_SECRET.getBytes()).compact();

        return token;
    }

    // get username from JWT
    public String getUserNameFromJWTToken(String token){
        String username = Jwts.parserBuilder().setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                .build().parseClaimsJws(token).getBody().getSubject();

        return username;
    }

    // validate token
    //TODO:


}
