package com.yasinsolak.xml;

public class MessageRepository implements INotification {

    public void sendMessage(){
        System.out.println("Müşteriye mesaj atıldı");
    }

    @Override
    public void sendNotification() {
        System.out.println("Müşteriye mesaj atıldı");
    }
}
