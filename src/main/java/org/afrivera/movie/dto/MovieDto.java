package org.afrivera.movie.dto;

import lombok.*;

import java.util.Date;




@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

    private Long id;
    private String name;
    private String image;
    private String description;
    private Date release_date;
}
