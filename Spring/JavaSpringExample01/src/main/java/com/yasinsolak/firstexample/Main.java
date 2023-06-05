package com.yasinsolak.firstexample;

import com.yasinsolak.xml.CustomerServiceXml;

/**
 * 1- Başlangıçta MessageRepository ve Customer service sınıflarımız olsun
 *    MessageRepoda sendmessage isimli bir metot olsun ve bu metot çıktı olarak mesaj atıldı yazılabilir.
 *    Daha sonra customer servicede bir sedmessage fonksiyonu yazıp repodaki fonksiyonu ve bu metot içinde çağıralım
 *    Test sınıfında service üzerinden çıktımızı alalım.
 */
public class Main {
    public static void main(String[] args) {
        CustomerServiceXml customerService = new CustomerServiceXml();
        customerService.sendMessage();

       // CustomerServiceXml customerService1 = new CustomerServiceXml(new MailRepository());
       // customerService1.sendMail();
        System.out.println("-----");
        CustomerService2 customerService2 = new CustomerService2(new MessageRepository());
        customerService2.setNotification();
    }
}