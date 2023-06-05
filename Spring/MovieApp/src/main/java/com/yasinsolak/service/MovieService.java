package com.yasinsolak.service;

import com.yasinsolak.entity.Movie;
import com.yasinsolak.repository.IMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final IMovieRepository movieRepository;

    public void save(Movie movie){
        movieRepository.save(movie);
    }
}
