package com.yemeksepeti.demo.repository.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 64 ,nullable = false)
    private String name;
    @Column(length = 64 ,nullable = false)
    private String surname;
    @Column(length = 64 , unique = true ,nullable = false)
    private String email;
    @Column(length = 64 ,nullable = false)
    private String address;
    private String phoneNumber;
    private String password;
    @Column(length = 64 ,nullable = false)
    private String cardDetails;
    private double balance;
    /**
     * 0 - INACTIVE
     * 1 - ACTIVE
     */
    @Builder.Default
    private String status = "0";
    private String activationCode;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private List<Orders> orders;
}
