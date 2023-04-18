package com.yasinsolak.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * name
 * surname
 * username --> unique olsun null olmasın
 * password --> null olmasın uzunluğu 32 olsun
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(unique = true , nullable = false)
    private String username;
    @Column(nullable = false , length = 32)
    private String password;
    @Embedded
    private Information information;
    @Column(name = "cinsiyet")
    @Enumerated(EnumType.STRING)
    private EGender eGender;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<String> interests;

    @ElementCollection
    private Map<EAddressType,Address> address;
    public User( String username, String password ,Information information,EGender eGender,List<String> interests,Map<EAddressType,Address> address) {

        this.username = username;
        this.password = password;
        this.information = information;
        this.eGender = eGender;
        this.interests = interests;
        this.address = address;
    }
    public User(){

    }

    public User(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
