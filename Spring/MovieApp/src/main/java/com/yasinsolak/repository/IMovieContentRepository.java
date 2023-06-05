package com.yasinsolak.repository;

import com.yasinsolak.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieContentRepository  extends JpaRepository<MovieComment,Long> {
}
