package com.yasinsolak.controller;

import com.yasinsolak.app.BAUtils;
import com.yasinsolak.entity.User;
import com.yasinsolak.service.UserSerivce;

import java.util.Optional;

public class UserController {

    private UserSerivce userSerivce;

    public UserController(){
        this.userSerivce = new UserSerivce();
    }

    public void saveUser(){
        String name = BAUtils.readString("İsminiz : ");
        String email = BAUtils.readString("Email : ");
        String password = BAUtils.readString("Şifreniz : ");
        User user = new User(name,email,password);
        userSerivce.save(user);
        System.out.println("İşlem başarılı "+user.getName()+" Kaydedildi.");
    }

    public User login() {
        //Email ile login olalım.
        String email = BAUtils.readString("Email : ");
        String password = BAUtils.readString("Şifreniz : ");
       Optional<User> userOptional =  userSerivce.findByEmail(email);
        return userOptional.get();
    }
}
