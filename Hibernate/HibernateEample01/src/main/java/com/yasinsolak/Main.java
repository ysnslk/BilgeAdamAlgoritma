package com.yasinsolak;

import com.yasinsolak.entity.*;
import com.yasinsolak.utility.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Session session;
    private static Transaction transaction;


    public static void main(String[] args) {
       session = HibernateUtils.getSessionFactory().openSession();
       transaction = session.beginTransaction();

        Map<EAddressType, Address> adres = new HashMap<>();
       adres.put(EAddressType.HOME,new Address("aaa","bbb","cccc"));
        List<String> list = Arrays.asList("Book","Comics");
       User user = new User("ahmetseker","123123",new Information("Ahmet","Şeker","Halil"), EGender.MAN,list,adres);
        session.save(user);
        transaction.commit();
        session.close();
    }
}