package org.afrivera.movie.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;




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

    @NotNull
    @NotEmpty
    private String description;
    private Date release_date;
}
