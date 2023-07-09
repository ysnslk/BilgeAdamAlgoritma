package com.yemeksepeti.demo.repository.entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double point;
    @Column(length = 64 ,nullable = false)
    private String address;

    @OneToMany
    @JoinColumn(name = "restaurant_id")
    private List<Product> products;

    @OneToMany
    @JoinColumn(name = "restaurant_id")
    private List<Orders> orders;
}
