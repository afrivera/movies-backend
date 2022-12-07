package org.afrivera.movie.mapper;

import org.afrivera.movie.auth.dto.UserRequestDto;
import org.afrivera.movie.auth.dto.UserResponseDto;
import org.afrivera.movie.auth.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    User userRequestDtoToUser(UserRequestDto userRequestDto);
    UserResponseDto userToUserResponseDto(User user);
}
