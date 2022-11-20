package org.afrivera.movie.seeder;

import lombok.RequiredArgsConstructor;
import org.afrivera.movie.entity.Genre;
import org.afrivera.movie.repository.GenreRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenreSeeder implements CommandLineRunner {

    private final GenreRepository genreRepository;


    @Override
    public void run(String... args) throws Exception {
        loadGenres();
    }

    private void loadGenres() {
        if(genreRepository.count() == 0){
            loadSeedGenre();
        }
    }

    private void loadSeedGenre() {
        genreRepository.save(buildGenre("ACTION"));
        genreRepository.save(buildGenre("COMEDY"));
        genreRepository.save(buildGenre("ROMANCE"));
        genreRepository.save(buildGenre("FANTASY"));
        genreRepository.save(buildGenre("DRAMA"));
        genreRepository.save(buildGenre("HORROR"));
        genreRepository.save(buildGenre("MYSTERY"));
        genreRepository.save(buildGenre("THRILLER"));
    }

    private Genre buildGenre(String name) {
        return new Genre(name);
    }
}
