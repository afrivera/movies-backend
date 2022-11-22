package org.afrivera.movie.service.impl;

import lombok.RequiredArgsConstructor;
import org.afrivera.movie.dto.MovieDto;
import org.afrivera.movie.entity.Genre;
import org.afrivera.movie.entity.Movie;
import org.afrivera.movie.exception.ResourceNotFoundException;
import org.afrivera.movie.mapper.MovieMapper;
import org.afrivera.movie.repository.GenreRepository;
import org.afrivera.movie.repository.MovieRepository;
import org.afrivera.movie.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final MovieMapper movieMapper;

    @Override
    @Transactional(readOnly = true)
    public List<MovieDto> getAllMovies(){
        List<Movie> movies = movieRepository.findAll();
        return  movies.stream().map(movie -> movieMapper.movieToMovieDto(movie)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public MovieDto getMovieById(Long movieId){
        Movie movie =findMovieById(movieId);
        return movieMapper.movieToMovieDto(movie);
    }

    @Override
    @Transactional
    public MovieDto updateMovie(Long movieId, MovieDto movieDto){
        Movie movie = findMovieById(movieId);
        movie.setName(movieDto.getName());
        return movieMapper.movieToMovieDto(movieRepository.save(movie));
    }

    @Override
    @Transactional
    public MovieDto addMovie(MovieDto movieDto){
        Movie newMovie = movieMapper.movieDtoToMovie(movieDto);
        Set<Genre> genres = new HashSet<>();
        movieDto.getGenres().stream()
                .forEach(genre -> {
                    Genre genre1 = findGenreByName(genre.getName());
                    genres.add(genre1);
                });
        newMovie.setGenres(genres);
        return movieMapper.movieToMovieDto(movieRepository.save(newMovie));
    }

    @Override
    @Transactional
    public HashMap<String, Object> destroymovie(Long movieId){
        Movie movie = findMovieById(movieId);
        HashMap<String, Object> response = new HashMap<>();
        movieRepository.delete(movie);
        response.put("message", "Movie was deleted");
        return response;
    }

    private Movie findMovieById(Long movieId){
        Optional<Movie> movie = movieRepository.findById(movieId);
        if(!movie.isPresent()){
            throw new ResourceNotFoundException("Movie", "id", movieId);
        }
        return movie.get();
    }

    private Genre findGenreByName(String name){
        Optional<Genre> genre = genreRepository.findOneByName(name);
        if(!genre.isPresent()){
            throw new ResourceNotFoundException("genre", "name", name);
        }
        return genre.get();
    }

}
