package com.yasinsolak.app;

import com.yasinsolak.controller.CategoryController;
import com.yasinsolak.controller.CustomerController;
import com.yasinsolak.controller.ProductController;
import com.yasinsolak.controller.ProductDetailController;
import com.yasinsolak.entity.Customer;

import java.util.HashMap;

public class Menu {

    private CategoryController categoryController;
    private ProductController productController;
    private CustomerController customerController;
    private ProductDetailController productDetailController;

    public Menu(){
        categoryController = new CategoryController();
        productController = new ProductController();
        customerController = new CustomerController();
        productDetailController = new ProductDetailController();
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
                customerMenu();
                break;
        }
    }

    private void adminMenu() {
        HashMap<Integer,String> menuItems = new HashMap<>();
        while (true){
            menuItems.put(1,"Category Ekle");
            menuItems.put(2,"Product Ekle");
            menuItems.put(3,"Product Listele");
            menuItems.put(4,"Menuye Don");
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
                case 3 :
                    productController.findAll();
                    System.out.println("\nProduct listed");
                    break;
                case 4 :
                   menu();
                    break;
            }
        }
    }

    private void customerMenu() {
        HashMap<Integer,String> menuItems = new HashMap<>();
        while (true){
            menuItems.put(1,"Kayıt Ol");
            menuItems.put(2,"Giriş Yap");
            int key = BAUtils.menu(menuItems);
            switch (key){
                case 1 :
                    customerController.register();
                    break;
                case 2 :
                    Customer customer = customerController.login();
                    if(customer != null){
                        customerManager(customer);
                    }
                    break;

            }
        }
    }

    private void customerManager(Customer customer) {
        System.out.println(customer.getFirstName());
        HashMap<Integer,String> menuItems = new HashMap<>();
        while (true){
            menuItems.put(1,"Satın Al");
            menuItems.put(2,"Ürüne yorum yap ve puan ver");
            menuItems.put(3,"Stoğu bitmek üzere olan ürünleri listeleyelim(10)");
            menuItems.put(4,"Producta göre yorumları listele");
            menuItems.put(5,"Hesabı yükselt");
            int key = BAUtils.menu(menuItems);
            switch (key){
                case 1 :
                    productController.buyProduct(customer);
                    break;
                case 2 :
                    productDetailController.makeCommentAndPuan();
                    break;
                case 3 :
                    productController.findProductStockLessThenTen();
                    break;
                case 4 :
                    productDetailController.findEvaluteByProductId();
                    break;
                case 5 :
                    customerController.changeAccountType(customer);
                    break;
            }
        }
    }
}
