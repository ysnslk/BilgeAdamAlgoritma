package com.bilgeadam.service;

import com.bilgeadam.entity.Instructor;
import com.bilgeadam.repository.IInstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstructorService {
    private final IInstructorRepository instructorRepository;

    public Instructor save(Instructor instructor){
        return instructorRepository.save(instructor);
    }
}
