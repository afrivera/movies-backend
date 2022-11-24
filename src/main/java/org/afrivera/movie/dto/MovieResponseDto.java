package org.afrivera.movie.dto;

import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDto {
    private String name;
    private String image;
    private String description;
    private Date release_date;
}
