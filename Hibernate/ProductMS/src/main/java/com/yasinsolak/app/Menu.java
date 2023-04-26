package com.yasinsolak.app;

import com.yasinsolak.controller.CategoryController;
import com.yasinsolak.controller.ProductController;

import java.util.HashMap;

public class Menu {

    private CategoryController categoryController;
    private ProductController productController;

    public Menu(){
        categoryController = new CategoryController();
        productController = new ProductController();
    }
    public void menu(){
        HashMap<Integer,String> menuItems = new HashMap<>();
        menuItems.put(1,"Admin");
        menuItems.put(2,"Customer");
        int key = BAUtils.menu(menuItems);
        switch (key){
            case 1:
                adminMenu();
                break;
            case 2:

                break;
        }
    }

    private void adminMenu() {
        HashMap<Integer,String> menuItems = new HashMap<>();
        while (true){
            menuItems.put(1,"Category Ekle");
            menuItems.put(2,"Product Ekle");
            int key = BAUtils.menu(menuItems);
            switch (key){
                case 1 :
                    categoryController.save();
                    System.out.println("Category added");
                    break;
                case 2 :
                    productController.save();
                    System.out.println("Product added");
                    break;
            }
        }
    }
}
