package org.afrivera.movie.service.impl;

import lombok.RequiredArgsConstructor;
import org.afrivera.movie.repository.StarRepository;
import org.afrivera.movie.service.StarService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StarServiceImpl implements StarService {

    private final StarRepository starRepository;


}
