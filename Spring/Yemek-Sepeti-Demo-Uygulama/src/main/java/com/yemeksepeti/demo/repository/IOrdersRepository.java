package com.yemeksepeti.demo.repository;

import com.yemeksepeti.demo.repository.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders,Long> {
    Optional<Orders> findOrdersByRestaurantId(Long resraurantId);

    Optional<Orders> findOrdersByCustomerId(Long customerId);
}
