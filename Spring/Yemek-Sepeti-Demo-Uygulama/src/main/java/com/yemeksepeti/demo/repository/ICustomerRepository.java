package com.yemeksepeti.demo.repository;

import com.yemeksepeti.demo.repository.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findOptionalByEmailAndPassword(String email, String password);
}
