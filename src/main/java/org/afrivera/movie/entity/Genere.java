package org.afrivera.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genre")
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Genere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long id;
    private String name;

    // @ManyToMany( cascade = CascadeType.ALL)
    // @JoinTable(name = "movie_genre", joinColumns = {
    //         @JoinColumn(name = "genre_id", referencedColumnName = "genre_id")
    // },
    //         inverseJoinColumns = {
    //         @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    //         }
    // )
    // private Set<Movie> movies =new HashSet<>();
}
