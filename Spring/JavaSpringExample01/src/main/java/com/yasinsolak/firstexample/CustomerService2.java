package com.yasinsolak.firstexample;

public class CustomerService2 {

    INotification notification;

    public CustomerService2(INotification notification){
        this.notification = notification;
    }

    public void setNotification(){
        notification.sendNotification();
    }
}
