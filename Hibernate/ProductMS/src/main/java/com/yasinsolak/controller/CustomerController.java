package com.yasinsolak.controller;

import com.yasinsolak.app.BAUtils;
import com.yasinsolak.entity.Customer;
import com.yasinsolak.service.CustomerService;

import java.util.HashMap;
import java.util.Optional;

public class CustomerController {

    private CustomerService customerService;

    public CustomerController(){
        this.customerService = new CustomerService();
    }

    public void register(){
        String fName = BAUtils.readString("First Name : ");
        String lastName = BAUtils.readString("Last Name : ");
        String email = BAUtils.readString("E-Mail : ");
        String identity = BAUtils.readString("Identity : ");
        String password = BAUtils.readString("Password : ");
        Customer customer = new Customer(fName,lastName,email,password,identity);
        customerService.save(customer);
        System.out.println("Kayıt Başarılı..!!!!!");
         /*
        customer.setFirstName(fName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setIdentity(identity);
        customer.setPassword(password);
        customerService.save(customer);
       */
    }

    public Customer login() {
        String identity = BAUtils.readString("Identity : ");
        String pasword = BAUtils.readString("Password : ");
        Optional<Customer> optionalCustomer = customerService.findByUdentity(identity);
        Customer customer;
        if(optionalCustomer.isEmpty()){
            System.out.println("Sistemde böyle bir kullanıcı bulunamamaktadır.");
        }else {
            customer = optionalCustomer.get();
            if(customer.getPassword().equals(pasword)){
               return customer;
                 }else {
                System.out.println("Hatalı Şifre");
            }
        }
        return null;
    }

    public void changeAccountType(Customer customer) {
        String accountType  = BAUtils.readString("Lütfen değiştirmek istediğiniz üyelik modelini belirtin");
        customerService.changeAccountType(customer ,accountType);

    }
}
