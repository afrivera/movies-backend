package org.afrivera.movie.auth.service;

import org.afrivera.movie.auth.dto.UserRequestDto;
import org.afrivera.movie.auth.dto.UserResponseDto;
import org.springframework.transaction.annotation.Transactional;


public interface UserService {
    @Transactional
    UserResponseDto addUser(UserRequestDto userRequestDto);
}
