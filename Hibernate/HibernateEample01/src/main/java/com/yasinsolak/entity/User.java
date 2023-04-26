package com.yasinsolak.entity;

/*
    name
    surname
    username--> uniqe olsun null olmasın
    password--> null olmasın uzunluguda 32 olsun
    user sınıfın içinde liste içinde interests
    AddressType--> Enum Home, Bussiness, Other
    Address--> street,country,city
    Hashmap yapısında userin içinde kullanalım
 */

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(length = 32, nullable = false)
    private String password;

    @Embedded
    private Information information;

    @Column(name = "cinsiye")
    @Enumerated(EnumType.STRING)
    private EGender eGender;

    @ElementCollection
    private List<String> interests;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Map<EAddressType, Address> adders;
    private int postcount;
    public User(String username, String password, Information information, EGender eGender, List<String> interests, Map<EAddressType, Address> adders, int
            postcount) {
        this.username = username;
        this.password = password;
        this.information = information;
        this.eGender = eGender;
        this.interests = interests;
        this.adders = adders;
        this.postcount = postcount;
    }

    public User(String username, String password, Information information, EGender eGender, List<String> interests, Map<EAddressType, Address> adders
    ) {
        this.username = username;
        this.password = password;
        this.information = information;
        this.eGender = eGender;
        this.interests = interests;
        this.adders = adders;

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, EGender eGender) {
        this.username = username;
        this.password = password;
        this.eGender = eGender;
    }

    public User() {

    }

    public int getPostcount() {
        return postcount;
    }

    public void setPostcount(int postcount) {
        this.postcount = postcount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public EGender geteGender() {
        return eGender;
    }

    public void seteGender(EGender eGender) {
        this.eGender = eGender;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public Map<EAddressType, Address> getAdders() {
        return adders;
    }

    public void setAdders(Map<EAddressType, Address> adders) {
        this.adders = adders;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", eGender=" + eGender +
                '}';
    }
}