package org.afrivera.movie.auth.service;

import org.afrivera.movie.auth.dto.LoginDto;
import org.afrivera.movie.auth.dto.UserRequestDto;
import org.afrivera.movie.auth.dto.UserResponseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

public interface UserService {
    @Transactional
    UserResponseDto addUser(UserRequestDto userRequestDto);

    HashMap<String, Object> login(LoginDto loginDto);
}
