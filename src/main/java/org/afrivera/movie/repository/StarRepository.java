package org.afrivera.movie.repository;

import org.afrivera.movie.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository extends JpaRepository<Star, Long> {
}
