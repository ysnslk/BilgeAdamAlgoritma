package org.yasinsolak.app;

import com.yasinsolak.app.BAUtils;

import java.util.HashMap;

public class Menu {
    //private UserController userController;
    public Menu(){
        //   this.userController = new UserController();
    }
    public void menu(){
        HashMap<Integer,String> menuItems = new HashMap<>();
        menuItems.put(1,"Register İşlemleri");
        menuItems.put(2,"Kullanıcı İşlemleri");

        int key = BAUtils.menu(menuItems);
        switch (key){
            case 1:
               // userController.saveUser();
                break;
            case 2:
               // User user =userController.login();
               // accountManagement(user);
                break;
        }
    }

    public void accountManagement(){
        HashMap<Integer,String> menuItems = new HashMap<>();
        menuItems.put(1,"Hesap Oluştur");
        menuItems.put(2,"Para Gönder");
        while (true){

            int key = BAUtils.menu(menuItems);
            switch (key){
                case 1:
                    //accountController.createAccount(user);
                    break;

            }
        }
    }
}
