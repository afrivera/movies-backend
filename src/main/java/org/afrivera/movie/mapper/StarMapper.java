package org.afrivera.movie.mapper;

import org.afrivera.movie.dto.StarRequestDto;
import org.afrivera.movie.entity.Star;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StarMapper {

    StarMapper starMapper = Mappers.getMapper(StarMapper.class);

    Star starDtoToStar(StarRequestDto starRequestDto);
    StarRequestDto starToStarDto(Star star);
}
