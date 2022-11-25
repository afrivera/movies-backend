package org.afrivera.movie.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StarRequestDto {

    private Long id;
    @NotNull
    private String name;
    private String image;
}
