package org.afrivera.movie.service.impl;

import lombok.RequiredArgsConstructor;
import org.afrivera.movie.dto.MovieDto;
import org.afrivera.movie.entity.Movie;
import org.afrivera.movie.mapper.MovieMapper;
import org.afrivera.movie.repository.MovieRepository;
import org.afrivera.movie.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Override
    @Transactional(readOnly = true)
    public List<MovieDto> getAllMovies(){
        List<Movie> movies = movieRepository.findAll();
        return  movies.stream().map(movie -> movieMapper.movieToMovieDto(movie)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MovieDto addMovie(MovieDto movieDto){
        Movie newMovie = movieMapper.movieDtoToMovie(movieDto);
        return movieMapper.movieToMovieDto(movieRepository.save(newMovie));
    }

}
