package org.afrivera.movie.auth.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    private Long id;
    private String name;
    private String lastName;
    private String username;
    private String email;
    private String image;
}
