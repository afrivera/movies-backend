package org.afrivera.movie.mapper;

import org.afrivera.movie.dto.MovieDto;
import org.afrivera.movie.entity.Movie;
import org.mapstruct.Mapper;

@Mapper
public interface MovieMapper {

    Movie movieDtoToMovie(MovieDto movieDto);
    MovieDto movieToMovieDto(Movie movie);
}
