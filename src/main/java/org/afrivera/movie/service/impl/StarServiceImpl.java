package org.afrivera.movie.service.impl;

import lombok.RequiredArgsConstructor;
import org.afrivera.movie.dto.StarRequestDto;
import org.afrivera.movie.entity.Star;
import org.afrivera.movie.mapper.StarMapper;
import org.afrivera.movie.repository.StarRepository;
import org.afrivera.movie.service.StarService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StarServiceImpl implements StarService {

    private final StarRepository starRepository;
    private final StarMapper starMapper;

    @Override
    @Transactional(readOnly = true)
    public List<StarRequestDto> getAllStars(){
        List<Star> stars = starRepository.findAll();
        return stars.stream().map(star->starMapper.starToStarDto(star)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public StarRequestDto addStar(StarRequestDto starRequestDto){
        Star newStar = starMapper.starDtoToStar(starRequestDto);
        return starMapper.starToStarDto(starRepository.save(newStar));
    }
}
