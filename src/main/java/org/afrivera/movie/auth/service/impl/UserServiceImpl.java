package org.afrivera.movie.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.afrivera.movie.auth.dto.UserRequestDto;
import org.afrivera.movie.auth.dto.UserResponseDto;
import org.afrivera.movie.auth.entity.User;
import org.afrivera.movie.auth.repository.UserRepository;
import org.afrivera.movie.auth.service.UserService;
import org.afrivera.movie.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserResponseDto addUser(UserRequestDto userRequestDto){
        User newUser = userMapper.userRequestDtoToUser(userRequestDto);
        return userMapper.userToUserResponseDto(userRepository.save(newUser));
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(()->new UsernameNotFoundException("username or email not found with: " + usernameOrEmail));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

}
