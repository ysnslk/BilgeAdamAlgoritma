package com.bilgeadam.repository;

import com.bilgeadam.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstructorRepository extends JpaRepository<Instructor, Long> {
}
