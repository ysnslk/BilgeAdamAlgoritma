package com.movieapp.repository;

import com.movieapp.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGenreRepository extends JpaRepository<Genre,Long> {

    Optional<Genre> findOptionalByName(String name);
}
