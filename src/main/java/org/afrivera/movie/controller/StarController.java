package org.afrivera.movie.controller;

import lombok.RequiredArgsConstructor;
import org.afrivera.movie.dto.StarRequestDto;
import org.afrivera.movie.service.StarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stars")
@RequiredArgsConstructor
public class StarController {

    private final StarService starService;

    @GetMapping
    public ResponseEntity<List<StarRequestDto>> getAllStars(){
        return new ResponseEntity<>(starService.getAllStars(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StarRequestDto> addStar(@RequestBody StarRequestDto starRequestDto){
        return new ResponseEntity<>(starService.addStar(starRequestDto), HttpStatus.CREATED);
    }

}
