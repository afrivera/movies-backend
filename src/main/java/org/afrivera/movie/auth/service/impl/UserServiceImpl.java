package org.afrivera.movie.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.afrivera.movie.auth.dto.UserRequestDto;
import org.afrivera.movie.auth.dto.UserResponseDto;
import org.afrivera.movie.auth.entity.User;
import org.afrivera.movie.auth.repository.UserRepository;
import org.afrivera.movie.auth.service.UserService;
import org.afrivera.movie.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponseDto addUser(UserRequestDto userRequestDto){
        User newUser = userMapper.userRequestDtoToUser(userRequestDto);
        return userMapper.userToUserResponseDto(userRepository.save(newUser));
    }
}
