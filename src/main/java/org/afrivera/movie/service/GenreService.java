package org.afrivera.movie.service;

import org.afrivera.movie.dto.GenreDto;
import org.afrivera.movie.dto.GenreResponseDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GenreService{

    @Transactional(readOnly = true)
    List<GenreDto> getAllGenres();

    @Transactional(readOnly = true)
    GenreResponseDto getMoviesByGenre(String name);
}
