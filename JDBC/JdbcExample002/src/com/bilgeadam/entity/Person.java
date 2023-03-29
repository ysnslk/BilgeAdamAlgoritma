package com.bilgeadam.entity;

import java.util.Date;

public class Person {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private Date joined_date;

    public Person(String first_name, String last_name, String email, Date joined_date) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.joined_date = joined_date;
    }

    public Person(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoined_date() {
        return joined_date;
    }

    public void setJoined_date(Date joined_date) {
        this.joined_date = joined_date;
    }
}
