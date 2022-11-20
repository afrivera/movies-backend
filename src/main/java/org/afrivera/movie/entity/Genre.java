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
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private Long id;
    private String name;

    @ManyToMany( mappedBy = "genres", cascade = CascadeType.ALL)

    private Set<Movie> movies =new HashSet<>();


    public Genre(String name) {
        this.name = name;
    }
}