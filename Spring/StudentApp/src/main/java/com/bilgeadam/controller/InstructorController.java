package com.bilgeadam.controller;

import com.bilgeadam.entity.Instructor;
import com.bilgeadam.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instructor")
public class InstructorController {
    private final InstructorService instructorService;

    @PostMapping("/save")
    public Instructor save(Instructor instructor){
        return instructorService.save(instructor);
    }
}
