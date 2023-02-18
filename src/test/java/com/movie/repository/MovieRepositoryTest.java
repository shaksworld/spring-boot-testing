package com.movie.repository;

import com.movie.model.Movie;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    private Movie avatarMovie;

    private Movie godfatherMovie;

    @BeforeEach
    void init() {
        avatarMovie = new Movie();
        avatarMovie.setName("Avatar");
        avatarMovie.setGenera("Action");
        avatarMovie.setReleaseDate(LocalDate.of(2009, 12, 12));
        movieRepository.save(avatarMovie);

        godfatherMovie = new Movie();
        godfatherMovie.setName("The Godfather");
        godfatherMovie.setGenera("Drama");
        godfatherMovie.setReleaseDate(LocalDate.of(2019, 12, 12));
        movieRepository.save(godfatherMovie);
    }

    @Test
    @DisplayName("Should return all movies")
    void saveMovie() {
        //arrange
        Movie newMovie = movieRepository.save(avatarMovie);

        //assert
        assertNotNull(newMovie);
    }

}