package org.afrivera.movie.mapper;

import org.afrivera.movie.dto.GenreDto;
import org.afrivera.movie.dto.GenreResponseDto;
import org.afrivera.movie.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {
    GenreMapper genreMapper = Mappers.getMapper(GenreMapper.class);

    Genre genreDtoToGenre(GenreResponseDto genreResponseDto);
    GenreDto genreToGenreDto(Genre genre);
    GenreResponseDto map(Genre genre);
}
