package com.yasinsolak.controller;

import com.yasinsolak.entity.MovieComment;
import com.yasinsolak.service.MovieCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import java.time.LocalDate;

@RestController
@RequestMapping("/moviecomment")
@RequiredArgsConstructor
public class MovieCommentController {

    private final MovieCommentService movieCommentService;

    @GetMapping("/filmcomment")
    public ResponseEntity<List<MovieComment>> findAllByMovie_Id(Long id){
        return ResponseEntity.ok(movieCommentService.findAllByMovie_Id(id));
    }

    @GetMapping("/filmcommentdate")
    public ResponseEntity<List<MovieComment>> findByDate(String name, LocalDate fdate, LocalDate ldate){
        return ResponseEntity.ok(movieCommentService.findByDate(name,fdate,ldate));
    }
    @GetMapping("/filmcommenvalue")
    public ResponseEntity<List<MovieComment>> findByContentContainingIgnoreCase(String name){
        return ResponseEntity.ok(movieCommentService.findByContentContainingIgnoreCase(name));
    }
    @GetMapping("/filmcommenlength")
    public ResponseEntity<List<MovieComment>> findByContentLengthGreaterThan(int length){
        return ResponseEntity.ok(movieCommentService.findByContentLengthGreaterThan(length));
    }
}
