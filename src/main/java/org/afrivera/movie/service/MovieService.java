package org.afrivera.movie.service;

import org.afrivera.movie.dto.MovieDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MovieService {
    @Transactional(readOnly = true)
    List<MovieDto> getAllMovies();

    MovieDto addMovie(MovieDto movieDto);
}
