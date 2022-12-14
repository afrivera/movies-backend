package org.afrivera.movie.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.afrivera.movie.auth.dto.LoginDto;
import org.afrivera.movie.auth.dto.UserRequestDto;
import org.afrivera.movie.auth.dto.UserResponseDto;
import org.afrivera.movie.auth.entity.User;
import org.afrivera.movie.auth.repository.UserRepository;
import org.afrivera.movie.auth.service.UserService;
import org.afrivera.movie.auth.util.JWTUtil;
import org.afrivera.movie.exception.MovieBackendException;
import org.afrivera.movie.mapper.UserMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;
    @Resource
    @Lazy
    private AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public UserResponseDto addUser(UserRequestDto userRequestDto){
        User newUser = userMapper.userRequestDtoToUser(userRequestDto);
        newUser.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        return userMapper.userToUserResponseDto(userRepository.save(newUser));
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(()->new UsernameNotFoundException("username or email not found with: " + usernameOrEmail));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

    @Override
    public HashMap<String, Object> login(LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(), loginDto.getPassword()
        ));
        if(Objects.isNull(authentication)){
            throw new MovieBackendException(HttpStatus.BAD_REQUEST, "Usuario o contraseña Incorrectos");
        }
        HashMap<String, Object> resp = new HashMap<>();
        String token = jwtUtil.generateJWTToken(authentication);
        resp.put("token", token);
        return resp;
    }

}
