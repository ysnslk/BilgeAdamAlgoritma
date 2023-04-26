package com.yasinsolak.controller;

import com.yasinsolak.entity.*;
import com.yasinsolak.repository.UserRepository;
import com.yasinsolak.utility.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {
    public static void main(String[] args) {
        //createUser();

        UserRepository userRepository = new UserRepository();
        //userRepository.findAll().forEach(System.out::println);

        //userRepository.findAllUserInformation().forEach(System.out::println);
        //userRepository.findAllInformationByName().forEach(System.out::println);

        //userRepository.findAllNativeQuery().forEach(System.out::println);
        //User user = userRepository.findById(2L);
        //System.out.println(user.getUsername() +" " +user.getInformation().getMiddleName());

        //User user =  userRepository.findByUsername("ali");
        //System.out.println(user.getUsername() +" "+ user.getPassword());


        //userRepository.findByUserStartWithValue("a").forEach(System.out::println);

        //userRepository.findByNameAndPostCount("a",4).forEach(System.out::println);

        //int postCount = userRepository.sumPost2();
        //System.out.println(postCount);

        //User user = userRepository.findUserWithMostPost();
        //System.out.println(user.getUsername() + " ---- " + user.getPostcount());

        //int postCount = userRepository.findUserWithMostPost2();
        //System.out.println(" " + postCount);

        //userRepository.getUsernameGenderPostCount();
        userRepository.getUserbyCountGender().forEach(x-> {
            for(Object o : x){
                System.out.print(o.toString() + "-");
            }
            System.out.println();
        });

    }



    public static void createUser() {
        Session session;
        Transaction transaction;

        session = HibernateUtils.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<String> list1 = Arrays.asList("Book", "Comics");
        List<String> list2 = Arrays.asList("Sport", "walking");
        List<String> list3 = Arrays.asList("film", "cinema");

        Map<EAddressType, Address> adres1 = new HashMap<>();
        adres1.put(EAddressType.HOME, new Address("Ankara", "Turkiye", "ayrancı"));

        Map<EAddressType, Address> adres2 = new HashMap<>();
        adres2.put(EAddressType.BUSINNESS, new Address("Paris", "Fransa", "XXX"));

        Map<EAddressType, Address> adres3 = new HashMap<>();
        adres3.put(EAddressType.HOME, new Address("Berlin", "Almanya", "YYY"));

        Information information = new Information("ali", "kaya", "yaz");
        User user = new User("ali", "1234", information, EGender.MAN, list1, adres1,4);

        Information information2 = new Information("mehmet", "kış", "son");
        User user2 = new User("osman", "1234", information2, EGender.OTHER, list2, adres2,6);

        Information information3 = new Information("aslı", "güçlü", "yaz");
        User user3 = new User("aslı123", "1234", information3, EGender.WOMAN, list3, adres3,2);

        Information information5 = new Information("zewynep", "zayıf", "zey");
        User user4 = new User("zeyn123", "456", information3, EGender.WOMAN, list3, adres3,12);

        Information information6 = new Information("buekt", "kuş", "bkt");
        User user5 = new User("buket123", "778899", information3, EGender.WOMAN, list3, adres3,4);


        session.save(user);
        session.save(user2);
        session.save(user3);
        session.save(user4);
        session.save(user5);
        transaction.commit();
        session.close();

    }
}

