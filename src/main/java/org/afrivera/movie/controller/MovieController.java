package org.afrivera.movie.controller;

import lombok.RequiredArgsConstructor;
import org.afrivera.movie.dto.MovieDto;
import org.afrivera.movie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("{movieId}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable(value = "movieId") Long movieId){
        return new ResponseEntity<>(movieService.getMovieById(movieId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovieDto> addMovie(@RequestBody @Valid MovieDto movieDto){
        return new ResponseEntity<>(movieService.addMovie(movieDto), HttpStatus.CREATED);
    }

    @PutMapping("{movieId}")
    public ResponseEntity<MovieDto> putMovie(@PathVariable(value = "movieId")Long movieId, @RequestBody MovieDto movieDto){
        return new ResponseEntity<>(movieService.updateMovie(movieId, movieDto), HttpStatus.OK);
    }

    @DeleteMapping("{movieId}")
    public ResponseEntity<HashMap<String, Object>> deleteMovie(@PathVariable(value = "movieId") Long movieId){
        return new ResponseEntity<>(movieService.destroymovie(movieId), HttpStatus.OK);
    }
}
