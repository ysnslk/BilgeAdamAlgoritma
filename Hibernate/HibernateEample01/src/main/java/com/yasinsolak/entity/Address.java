package com.yasinsolak.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String street;
    private String country;

    public Address(String street, String country, String city) {
        this.street = street;
        this.country = country;
        this.city = city;
    }

    private String city;

    public Address() {
    }
}
