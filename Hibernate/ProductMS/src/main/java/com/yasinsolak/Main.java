package com.yasinsolak;

import com.yasinsolak.app.Menu;
import com.yasinsolak.util.HibernateUtility;

public class Main {
    public static void main(String[] args) {

       // HibernateUtility.getSessionFactory().openSession();
        Menu menu = new Menu();
        menu.menu();
    }
}