package com.yasinsolak.utility;

import java.util.List;
import java.util.Optional;

public interface ICrud<T, ID> {
    <S extends T> S save(S entity);

    <S extends T> S update(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> entites);

    void delete(T entity);

    void deleteById(ID id);

    Optional<T> findById(ID id);

    boolean existById(ID id);

    List<T> findAll();

    List<T> findByEntity(T entity);

}