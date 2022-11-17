package org.afrivera.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "star")
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class Star {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "star_id")
    private Long id;
    private String name;
    private String image;

    //@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //@JoinTable(name = "star_movie",
    //joinColumns = {
    //        @JoinColumn(name = "star_id", referencedColumnName = "star_id")
    //},
    //inverseJoinColumns = {
    //        @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    //})
    //private Set<Movie> films = new HashSet<>();
}
