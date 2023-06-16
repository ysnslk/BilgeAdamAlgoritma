package com.movieapp.controller;

import com.movieapp.dto.request.MovieCommentSaveRequestDto;
import com.movieapp.service.MovieCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/moviecomment")
public class MovieCommentController {

    private MovieCommentService movieCommentService;

    @PostMapping("/save")
    public ModelAndView save(MovieCommentSaveRequestDto dto){
        movieCommentService.save(dto);
        ModelAndView modelAndView = new ModelAndView();
        //modelAndView.addObject("id",dto.getMovieId());
        //modelAndView.addObject("userId",dto.getUserId());
        //modelAndView.setViewName("redirect:/movie/findbyid");
        modelAndView.setViewName("redirect:/movie/findbyid?id="+dto.getMovieId()+"&userId="+dto.getUserId());
        return modelAndView;
    }
}