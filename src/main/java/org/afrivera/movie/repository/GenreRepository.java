package org.afrivera.movie.repository;

import org.afrivera.movie.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Optional<Genre> findOneByName(String name);
}
