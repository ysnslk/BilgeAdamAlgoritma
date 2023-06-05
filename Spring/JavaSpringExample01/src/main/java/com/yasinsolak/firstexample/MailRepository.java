package com.yasinsolak.firstexample;

public class MailRepository implements INotification{
    public void sendMail(){
        System.out.println("Müşteriye mail atıldı");
    }

    @Override
    public void sendNotification() {
        System.out.println("Müşteriye mail atıldı");
    }
}
