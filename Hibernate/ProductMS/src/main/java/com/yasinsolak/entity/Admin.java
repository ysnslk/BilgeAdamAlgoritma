package com.yasinsolak.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_admin")
public class Admin extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Admin(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public Admin() {

    }
}
