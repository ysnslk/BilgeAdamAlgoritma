package com.yasinsolak.repository;

import com.yasinsolak.entity.Genre;
import com.yasinsolak.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findAllByRatingGreaterThan(double value);
    List<Movie> findAllByGenreInOrderByRatingDesc(List<Genre> genres);
    List<Movie> findAllByPremieredBefore(LocalDate date);
    @Query("Select count(m.rating),m.rating from Movie m where m.rating = ?1 group by m.rating")
    List<Object> findAllByRatingCountGreaterThan(Double rate);
    List<Movie> findAllByRatingIn(List<Double> ratings);
    List<Movie> findAllByNameIn(String[] names);
    @Query("Select count(m.country),m.country from Movie m  group by m.country")
    List<Movie> findAllByCountryCount();

}
