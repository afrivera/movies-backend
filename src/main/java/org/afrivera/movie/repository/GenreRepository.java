package org.afrivera.movie.repository;

import org.afrivera.movie.entity.Genere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genere, Long> {
}
