package org.afrivera.movie.service;

import org.afrivera.movie.dto.StarRequestDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StarService {
    @Transactional(readOnly = true)
    List<StarRequestDto> getAllStars();

    @Transactional
    StarRequestDto addStar(StarRequestDto starRequestDto);
}
