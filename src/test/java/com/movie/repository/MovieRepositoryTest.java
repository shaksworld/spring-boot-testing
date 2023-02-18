package com.movie.repository;

import com.movie.model.Movie;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AllArgsConstructor
class MovieRepositoryTest {

    private MovieRepository movieRepository;

    @Test
    void saveMovie() {
        //arrange
        Movie movie = new Movie();
        movie.setName("The Godfather");
        movie.setGenera("Drama");
        movie.setReleaseDate(LocalDate.of(2019, 12, 12));
        //act
        movieRepository.save(movie);
        //assert
        assertNotNull(movie.getId());
        assertEquals("The Godfather", movie.getName());
    }

}