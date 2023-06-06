package com.yasinsolak.repository;

import com.yasinsolak.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    List<User> findAllByOrderByName();
    List<User> findAllByNameLike(String name);
    List<User> findByEmailContainingIgnoreCase(String email);
    List<User> findAllByEmailEndsWith(String value);
    List<User> findAllByEmailEndingWith(String value);
    List<User> findAllByEmailStartingWith(String value);
    List<User> findAllByEmailStartsWith(String value);
    Boolean existsByEmailAndPassword(String email,String password);
    Optional<User> findByEmailIgnoreCaseAndPassword(String email,String password);
    @Query("select u from User u where length(u.password)> :x ")
    List<User> passwordLongerThen(@Param("x") int length);
}
