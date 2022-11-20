package org.afrivera.movie.dto;

import lombok.*;
import org.afrivera.movie.entity.Genre;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private Long id;

    @NotNull
    @NotEmpty
    private String name;
    private String image;
    private Set<GenreDto> genres;

    @NotNull
    @NotEmpty
    private String description;
    private Date release_date;
}
