package com.yasinsolak.controller;

import com.yasinsolak.entity.Genre;
import com.yasinsolak.entity.Movie;
import com.yasinsolak.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/findall")
    public ResponseEntity<List<Movie>> findAll(){
        return ResponseEntity.ok(movieService.findAll());
    }
    @GetMapping("/greaterthan")
    public ResponseEntity<List<Movie>> findAllByRatingGreaterThan(double value){
        return ResponseEntity.ok(movieService.findAllByRatingGreaterThan(value));
    }

    @GetMapping("/findmoviesbygenres")
    public ResponseEntity<List<Movie>> findMoviesByUserGenres(Long id){
        return ResponseEntity.ok(movieService.findMoviesByUserGenres(id));
    }
    @GetMapping("/findbeforedate")
    public ResponseEntity<List<Movie>> findAllByPremieredBefore(LocalDate date){
        return ResponseEntity.ok(movieService.findAllByPremieredBefore(date));
    }
    @GetMapping("/findallratingcountgreaterthan")
    public ResponseEntity<List<Object>> findAllByRatingCountGreaterThan(Double rate){
        return ResponseEntity.ok(movieService.findAllByRatingCountGreaterThan(rate));
    }
    @GetMapping("/searchrating789")
    public ResponseEntity<List<Movie>> findAllByRatingIn(){
        return ResponseEntity.ok(movieService.findAllByRatingIn());
    }
    @GetMapping("/searchbynames")
    public ResponseEntity<List<Movie>> findAllByNameIn(String[] names){
        return ResponseEntity.ok(movieService.findAllByNameIn(names));
    }
    @GetMapping("/findallbycountrycount")
    public ResponseEntity<List<Movie>> findAllByCountryCount(){
        return ResponseEntity.ok(movieService.findAllByCountryCount());
    }

}
