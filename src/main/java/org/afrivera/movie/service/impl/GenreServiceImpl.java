package org.afrivera.movie.service.impl;

import lombok.RequiredArgsConstructor;
import org.afrivera.movie.dto.GenreResponseDto;
import org.afrivera.movie.entity.Genre;
import org.afrivera.movie.mapper.GenreMapper;
import org.afrivera.movie.repository.GenreRepository;
import org.afrivera.movie.service.GenreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    @Transactional(readOnly = true)
    public List<GenreResponseDto> getAllGenders(){
        List<Genre> genres = genreRepository.findAll();
        return genres.stream().map(genre -> genreMapper.genreToGenreDto(genre)).collect(Collectors.toList());
    }

}
