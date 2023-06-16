package com.movieapp.controller;

import com.movieapp.dto.response.UserLoginResponseDto;
import com.movieapp.entity.Genre;
import com.movieapp.entity.Movie;
import com.movieapp.entity.User;
import com.movieapp.service.GenreService;
import com.movieapp.service.MovieService;
import com.movieapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final GenreService genreService;
    private final UserService userService;
    @GetMapping("")
    public ModelAndView getMoviePage(UserLoginResponseDto responseDto,String[] genre){
        ModelAndView modelAndView = new ModelAndView();
        List<Movie> movieList ;
        List<Genre> genreList = genreService.findAll();
        if(genre == null){
          movieList = movieService.findAll();
        }else{
            movieList = movieService.findAllByGenres(genre);
        }
        modelAndView.addObject("movieListesi",movieList);
        modelAndView.addObject("genreListesi",genreList);
        modelAndView.addObject("userBilgileri",responseDto);
        modelAndView.setViewName("movies");
        return modelAndView;
    }

    @GetMapping("/findbyid")
    public ModelAndView getById(Long id,Long userId){
        User user = null;
        if (userId==null){
            user = User.builder().build();
        }else{
            user = userService.findById(userId).get();
        }
        Movie movie = movieService.findbyId(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("movie",movie);
        modelAndView.addObject("userBilgileri",user);
        modelAndView.setViewName("moviesDetail");
        return modelAndView;
    }
}
