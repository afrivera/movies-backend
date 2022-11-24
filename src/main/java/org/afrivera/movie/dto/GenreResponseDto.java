package org.afrivera.movie.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenreResponseDto {
    private String name;
    private Set<MovieResponseDto> movies;
}
