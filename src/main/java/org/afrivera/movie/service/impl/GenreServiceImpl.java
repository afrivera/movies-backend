package org.afrivera.movie.service.impl;

import lombok.RequiredArgsConstructor;
import org.afrivera.movie.dto.GenreDto;
import org.afrivera.movie.dto.GenreResponseDto;
import org.afrivera.movie.entity.Genre;
import org.afrivera.movie.exception.ResourceNotFoundException;
import org.afrivera.movie.mapper.GenreMapper;
import org.afrivera.movie.repository.GenreRepository;
import org.afrivera.movie.service.GenreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    @Transactional(readOnly = true)
    public List<GenreDto> getAllGenres(){
        List<Genre> genres = genreRepository.findAll();
        return genres.stream().map(genre -> genreMapper.genreToGenreDto(genre)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public GenreResponseDto getMoviesByGenre(String name){
        return genreMapper.genreResponseDto(findGenreByName(name));
    }


    private Genre findGenreByName(String name){
        Optional<Genre> genre = genreRepository.findOneByName(name);
        if(!genre.isPresent()){
            throw new ResourceNotFoundException("genre", "name", name);
        }
        return genre.get();
    }

}
