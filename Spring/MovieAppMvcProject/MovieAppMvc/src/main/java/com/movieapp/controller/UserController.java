package com.movieapp.controller;

import com.movieapp.dto.request.UserLoginRequestDto;
import com.movieapp.dto.request.UserRegisterRequestDto;
import com.movieapp.dto.response.UserLoginResponseDto;
import com.movieapp.dto.response.UserRegisterResponseDto;
import com.movieapp.entity.Genre;
import com.movieapp.entity.Movie;
import com.movieapp.service.GenreService;
import com.movieapp.service.MovieService;
import com.movieapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    //register işlemi
    //daha önceden o email ile kayıt olunmuş mu kontrol edelim
    //eğer veritabanında o email var ise hata fırlatalım
    //yoksa kaydetsin
    //dto, repository, service katmanını, mapper0

    private final UserService userService;
    private final MovieService movieService;
    private final GenreService genreService;

    @GetMapping("/registerPage")
    public ModelAndView getRegisterPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(UserRegisterRequestDto dto){
        String error ="";
        ModelAndView modelAndView = new ModelAndView();
        UserRegisterResponseDto responseDto = new UserRegisterResponseDto();
        try {
            responseDto = userService.save(dto);
            System.out.println("dto--->  "+responseDto);
            modelAndView.addObject("email",responseDto.getEmail());
            modelAndView.setViewName("login");
        }catch (Exception ex){
            error = ex.getMessage();
            modelAndView.setViewName("register");
            modelAndView.addObject("error",error);
        }
        return modelAndView;
    }
    @GetMapping("/loginPage")
    public ModelAndView getLoginPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(UserLoginRequestDto dto){
        String error ="";
        ModelAndView modelAndView = new ModelAndView();
        try {
          UserLoginResponseDto responseDto =  userService.login(dto);
            List<Movie> movieList = movieService.findAll();
            List<Genre> genreList = genreService.findAll();
            modelAndView.addObject("movieListesi",movieList);
            modelAndView.addObject("genreListesi",genreList);
            modelAndView.addObject("userBilgileri",responseDto);
            modelAndView.setViewName("movies");
        }catch (Exception ex){
            error = ex.getMessage();
            modelAndView.addObject("result", ex.getMessage());
            modelAndView.setViewName("login");
             }
        return modelAndView;
    }
}