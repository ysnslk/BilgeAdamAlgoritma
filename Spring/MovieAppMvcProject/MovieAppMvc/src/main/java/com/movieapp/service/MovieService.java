package com.movieapp.service;

import com.movieapp.entity.Genre;
import com.movieapp.entity.Movie;
import com.movieapp.entity.User;
import com.movieapp.repository.IMovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final IMovieRepository movieRepository;
    public List<Movie> findAll(){
        return movieRepository.findAll();
    }
    public Movie save(Movie movie){
        return movieRepository.save(movie);
    }
    public List<Movie> findAllByIds(List<Long> ids) {
        return ids.stream().map(x-> movieRepository.findById(x).get()).collect(Collectors.toList());
    }
    public Movie findbyId(long id){
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isPresent()){
            return optionalMovie.get();
        }else{
            throw  new RuntimeException("Film bulunamadı");
        }
    }

    public List<Movie> findAllByGenres(String[] genre){
        return movieRepository.findAllByGenre_NameIn(genre);
    }

}
