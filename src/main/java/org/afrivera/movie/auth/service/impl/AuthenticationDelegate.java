package org.afrivera.movie.auth.service.impl;

import lombok.AllArgsConstructor;
import org.afrivera.movie.auth.dto.LoginDto;
import org.afrivera.movie.auth.service.IAuthenticationManager;
import org.afrivera.movie.exception.InvalidCredentialsException;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
//@AllArgsConstructor
public class AuthenticationDelegate implements IAuthenticationManager {

    @Lazy
    @Resource
    private AuthenticationManager authenticationManager;

    @Override
    public void authenticated(LoginDto loginDto){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginDto.getEmail(), loginDto.getPassword()
            ));
        }catch (Exception e){
            throw new InvalidCredentialsException("email or password incorrect");
        }
    }
}
