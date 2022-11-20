package org.afrivera.movie.mapper;

import org.afrivera.movie.dto.GenreDto;
import org.afrivera.movie.dto.MovieDto;
import org.afrivera.movie.entity.Genre;
import org.afrivera.movie.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);
    Movie movieDtoToMovie(MovieDto movieDto);
    MovieDto movieToMovieDto(Movie movie);
    GenreDto map(Genre genre);
}
