package com.yemeksepeti.demo.repository;

import com.yemeksepeti.demo.repository.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant,Long> {
}
