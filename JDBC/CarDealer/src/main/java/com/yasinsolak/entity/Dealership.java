package com.yasinsolak.entity;

public class Dealership {

    private long id;
    private String name;
    private String city;
    private String country;

    public Dealership(long id, String name, String city, String country) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public Dealership(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public Dealership() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Dealership{" + "id=" + id + ", name=" + name + ", city=" + city + ", country=" + country + '}';
    }

}
