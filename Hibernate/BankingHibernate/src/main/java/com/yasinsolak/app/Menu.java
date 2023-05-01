package com.yasinsolak.app;

import com.yasinsolak.controller.AccountController;
import com.yasinsolak.controller.UserController;
import com.yasinsolak.entity.User;

import java.util.HashMap;

public class Menu {
    private UserController userController;
    private AccountController accountController;
    public Menu(){
        this.userController = new UserController();
        this.accountController = new AccountController();
    }
    public void menu(){
        HashMap<Integer,String> menuItems = new HashMap<>();
        menuItems.put(1,"Register İşlemleri");
        menuItems.put(2,"Kullanıcı İşlemleri");

        int key = BAUtils.menu(menuItems);
        switch (key){
            case 1:
                userController.saveUser();
                break;
            case 2:
                User user =userController.login();
                accountManagement(user);
                break;
        }
    }

    public void accountManagement(User user){
        HashMap<Integer,String> menuItems = new HashMap<>();
        menuItems.put(1,"Hesap Oluştur");
        menuItems.put(2,"Para Gönder");
        while (true){

            int key = BAUtils.menu(menuItems);
            switch (key){
                case 1:
                    accountController.createAccount(user);
                    break;
                case 2:
                    accountController.transferMoney(user);
                    break;
            }
        }
    }
}
