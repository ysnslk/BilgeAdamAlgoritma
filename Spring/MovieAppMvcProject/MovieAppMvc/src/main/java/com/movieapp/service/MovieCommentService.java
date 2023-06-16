package com.movieapp.service;

import com.movieapp.dto.request.MovieCommentSaveRequestDto;
import com.movieapp.entity.Movie;
import com.movieapp.entity.MovieComment;
import com.movieapp.entity.User;
import com.movieapp.repository.IMovieCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieCommentService {
    private final IMovieCommentRepository movieCommentRepository;
    private final UserService userService;
    private final MovieService movieService;

    public void save(MovieCommentSaveRequestDto dto) {
        User user = userService.findById(dto.getUserId()).get();
        Movie movie = movieService.findbyId(dto.getMovieId());

        MovieComment movieComment = MovieComment.builder()
                .content(dto.getContent())
                .user(user)
                .movie(movie)
                .build();
        movieCommentRepository.save(movieComment);

        /*
        MovieComment movieComment= IMovieCommentMapper.INSTANCE.toMovieComment(dto);
        movieComment.setMovie(movie);
        movieComment.setUser(user);
         */

    }

}
