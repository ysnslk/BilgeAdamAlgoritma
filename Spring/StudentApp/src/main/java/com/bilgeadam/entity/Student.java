package com.bilgeadam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String classNo;
    @JsonIgnore
    @OneToMany
    private List<Course> courses;



    /**
     * //a,b,c  --> öğrenci 1,2,3-> Öğretmen
     * // 1 --> a, b  1 --> c
     * // 2 --> a, c
     * // 3 --> a, b, c
     * // a --> 1, 2 --> OneToMany
     * // 3 --> a, b --> ManyToOne
     * a,b,c 1,2,3
     * a --> 1,2
     * 1 --> a,b
     * a,b --> 1,2
     * 2,3 --> a,b
     */



}
