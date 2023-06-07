package com.yasinsolak.service;

import com.yasinsolak.entity.Genre;
import com.yasinsolak.entity.Movie;
import com.yasinsolak.entity.User;
import com.yasinsolak.repository.IMovieRepository;
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
    private final UserService userService;

    public Movie save(Movie movie){
       return movieRepository.save(movie);
    }

    public Movie findbyId(long id){
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isPresent()){
            return optionalMovie.get();
        }else{
            throw  new RuntimeException("Film bulunamadı");
        }
    }

    public List<Movie> findAllByIds(List<Long> ids) {
        return ids.stream().map(x-> movieRepository.findById(x).get()).collect(Collectors.toList());
    }

    public List<Movie> findAllByIds2(List<Long> ids) {
        return ids.stream().map(x-> movieRepository.findById(x).get()).collect(Collectors.toList());
    }

    public List<Movie> findAllByRatingGreaterThan(double value){
        return movieRepository.findAllByRatingGreaterThan(value);
    }

    public List<Movie> findMoviesByUserGenres(Long id){
        //Veritabanını kontrol edelim.
        //User var mı yok mu ?
        //Varsa genre listesini çekip reporya gönder.
        Optional<User>optionalUser = userService.findById(id);
        List<Genre> genreList = optionalUser.get().getFavGenres();
        if (genreList.size() > 0){
            return movieRepository.findAllByGenreInOrderByRatingDesc(genreList);
        }else{
            throw  new RuntimeException("Favlanan Genre Yok");
        }
    }
    public List<Movie> findAllByPremieredBefore(LocalDate date){
        return movieRepository.findAllByPremieredBefore(date);
    }
    public List<Object> findAllByRatingCountGreaterThan(Double rate){
        return movieRepository.findAllByRatingCountGreaterThan(rate);
    }

    public List<Movie> findAllByRatingIn( ){
        List<Double> ratings = List.of(7D,8D,9D);
        return movieRepository.findAllByRatingIn(ratings);
    }
    public List<Movie> findAllByNameIn(String[] names){
        return movieRepository.findAllByNameIn(names);
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }


}
