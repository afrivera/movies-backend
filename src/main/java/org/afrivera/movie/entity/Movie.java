package org.afrivera.movie.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;

    private String name;
    private String image;
    private String description;
    private Date release_date;

    //@ManyToMany(mappedBy = "movies", cascade = {CascadeType.ALL})
    //private Set<Genere> generes = new HashSet<>();
//
    //@ManyToMany(mappedBy = "films", cascade = {CascadeType.ALL})
    //private Set<Star> cast = new HashSet<>();

}
