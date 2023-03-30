package com.bilgeadam.util;

import com.bilgeadam.controller.PersonController;
import com.bilgeadam.entity.Person;

import java.util.Date;
import java.util.Scanner;

public class Menu {

    private final PersonController personController;

    public Menu() {
        this.personController = new PersonController();
    }

    public void menu() {
        /*
        1* insertPerson();

        2- getAllPersons();

        3- deleteAllRecords();

        4- updateEmail(String email , int id); --> transaction

        5- getPersonById(int id);

        6- deletePerson(int id); --> transaction
         */

        PersonController personController = new PersonController();
        Person person;
        boolean control = false;
        String first_name = "";
        String last_name = "";
        String email = "";
        int id = 0;
        while (!control) {
            System.out.println("\n - - - - - - - - - - - - - - - - - -\n");
            System.out.println(
                    "1- Kişi Ekle\n" +
                            "2- Bütün Kişileri Getir\n" +
                            "3- Bütün Kayıtları Sil\n" +
                            "4- Mail Adresini Güncelle\n" +
                            "5- ID'ye göre Kişi Getir\n" +
                            "6- ID'ye göre Kişi Sil\n" +
                            "0- Çıkış\n" +
                            "Seçiminiz :\n "
            );
            Scanner sc = new Scanner(System.in);
            int result = sc.nextInt();

            switch (result) {
                case 1:
                    System.out.println("\n");
                    first_name = Util.stringValue("Adınız : ");
                    last_name = Util.stringValue("Soyadınız : ");
                    email = Util.stringValue("Mail Adresiniz : ");
                    person = new Person(first_name, last_name, email, new Date());
                    personController.insertPerson(person);
                    break;
                case 2:
                    System.out.println("\n");
                    personController.getAllPerson();
                    break;
                case 3:
                    System.out.println("\n");
                    personController.deleteAllRecords();
                    break;
                case 4:
                    System.out.println("\n");
                    String newMail = Util.stringValue("Mail Adresiniz : ");
                    id = Util.intValue("Lütfen değiştirmek istediğiniz kişinin Id'sini girin :");
                    personController.updateEmail(newMail, id);
                    break;
                case 5:
                    System.out.println("\n");
                    id = Util.intValue("Lütfen görmek istediğiniz kişinin Id'sini girin :");
                    personController.getPersonById(id);
                    break;
                case 6:
                    System.out.println("\n");
                    id = Util.intValue("Lütfen silmek istediğiniz kişinin Id'sini girin :");
                    personController.deletePersonById(id);
                    break;
                case 0:
                    System.out.println("\n");
                    System.out.println("Çıkış yapıldı...!");
                    control = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir rakam girin!!!! (0 - 6)");
                    break;
            }
        }

    }
}
