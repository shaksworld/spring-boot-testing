package com.movie.service;

import com.movie.model.Movie;
import com.movie.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


public interface MovieService {

    Movie save(Movie movie);

    Movie update(Movie movie, Long id);

    Movie findAllMovies();

    Movie findById(Long id);

    void deleteById(Long id);

}
