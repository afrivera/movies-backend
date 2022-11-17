package org.afrivera.movie.service.impl;

import lombok.RequiredArgsConstructor;
import org.afrivera.movie.dto.MovieDto;
import org.afrivera.movie.entity.Movie;
import org.afrivera.movie.mapper.MovieMapper;
import org.afrivera.movie.repository.MovieRepository;
import org.afrivera.movie.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    // @Transactional
    public MovieDto addMovie(MovieDto movieDto){
        Movie newMovie = movieMapper.movieDtoToMovie(movieDto);
        return movieMapper.movieToMovieDto(movieRepository.save(newMovie));
    }


}
