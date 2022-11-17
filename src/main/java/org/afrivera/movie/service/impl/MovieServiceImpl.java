package org.afrivera.movie.service.impl;

import lombok.RequiredArgsConstructor;
import org.afrivera.movie.repository.MovieRepository;
import org.afrivera.movie.service.MovieService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;


}
