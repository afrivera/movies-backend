package org.afrivera.movie.service;

import org.afrivera.movie.dto.StarRequestDto;
import org.springframework.transaction.annotation.Transactional;

public interface StarService {
    @Transactional
    StarRequestDto addStar(StarRequestDto starRequestDto);
}
