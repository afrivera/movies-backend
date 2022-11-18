package org.afrivera.movie.service;

import org.afrivera.movie.dto.MovieDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MovieService {
    @Transactional(readOnly = true)
    List<MovieDto> getAllMovies();

    @Transactional(readOnly = true)
    MovieDto getMovieById(Long movieId);

    @Transactional
    MovieDto updateMovie(Long movieId, MovieDto movieDto);

    MovieDto addMovie(MovieDto movieDto);
}
