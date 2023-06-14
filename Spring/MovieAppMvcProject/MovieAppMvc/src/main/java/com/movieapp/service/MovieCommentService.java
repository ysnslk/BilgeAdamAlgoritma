package com.movieapp.service;

import com.movieapp.entity.MovieComment;
import com.movieapp.repository.IMovieCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieCommentService {

    private final IMovieCommentRepository movieCommentRepository;


}
