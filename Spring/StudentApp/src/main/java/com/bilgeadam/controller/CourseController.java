package com.bilgeadam.controller;

import com.bilgeadam.entity.Course;
import com.bilgeadam.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instructor")
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/save")
    public ResponseEntity<Course> save(Course course){
        return ResponseEntity.ok(courseService.save(course));
    }
}
