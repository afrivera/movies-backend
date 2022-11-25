package org.afrivera.movie.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "movie_genre", joinColumns = {
            @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
            }
    )
    @JsonBackReference
    private Set<Genre> genres = new HashSet<>();

    @ManyToMany(mappedBy = "films", cascade = {CascadeType.ALL})
    private Set<Star> cast = new HashSet<>();

}
