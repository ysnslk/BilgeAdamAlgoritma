package com.movieapp.entity;

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
@Table(name = "tbluser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surname;
    @Column(length = 50)
    private String email;
    @Column(length = 15)
    private String phone;
    @Column(length = 32)
    private String password;
    private String tcKimlikNo;
    @ManyToMany
    private List<Movie> favMovies;
    @ManyToMany
    private List<Genre> favGenres;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL) // CascadeType.ALL commentleride oluşturacak
    private List<MovieComment> comments;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EUserType userType = EUserType.USER;

}
