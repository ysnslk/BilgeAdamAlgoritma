package com.yasinsolak.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
public class Information {
    /*
        Information sınıfını veritabanında tablo olarak kullanmak istemiyorum
        ama bu sınıfı user sınıfın içinde kullanmak istiyoprum
     */
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return "Information{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }
}
