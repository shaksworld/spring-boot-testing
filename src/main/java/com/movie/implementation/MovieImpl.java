package com.movie.implementation;

import com.movie.model.Movie;
import com.movie.repository.MovieRepository;
import com.movie.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class MovieImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie update(Movie movie, Long id){
        Movie existingMovie = movieRepository.findById(id).get();
        existingMovie.setName(movie.getName());
        existingMovie.setGenera(movie.getGenera());
        existingMovie.setReleaseDate(movie.getReleaseDate());
        return movieRepository.save(existingMovie);
    }

    @Override
    public Movie findAllMovies() {
        return (Movie) movieRepository.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        Movie movie = movieRepository.findById(id).get();
        movieRepository.delete(movie);

    }
}
