package com.bilgeadam.service;

import com.bilgeadam.entity.Course;
import com.bilgeadam.repository.ICourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final ICourseRepository courseRepository;

    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
