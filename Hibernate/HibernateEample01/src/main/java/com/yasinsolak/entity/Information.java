package com.yasinsolak.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
public class Information {

    private String name;
    private String surname;

    private String middleName;


    public Information(String name, String surname, String middleName) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
    }

    public Information() {

    }
}
