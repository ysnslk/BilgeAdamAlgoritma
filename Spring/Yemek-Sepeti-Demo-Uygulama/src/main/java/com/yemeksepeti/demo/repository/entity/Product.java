package com.yemeksepeti.demo.repository.entity;



import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 64 ,nullable = false)
    private String name;
    @Column(length = 64 ,nullable = false)
    private String category;
    private double cost;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Orders> orders;

}
