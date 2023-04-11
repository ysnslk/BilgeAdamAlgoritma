/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yasinsolak.main;

import com.yasinsolak.entity.Car;
import com.yasinsolak.repository.CarRepository;
import com.yasinsolak.util.Constant;
import com.yasinsolak.util.FileUtil;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager {

    Scanner scanner = new Scanner(System.in);
    private final CarRepository carRepository = new CarRepository();

    public static void main(String[] args) throws IOException {

        Manager manager = new Manager();
        manager.menu();

    }

    public void menu() throws IOException {

        int input = 0;
        do {
            System.out.println("0-çıkış");
            System.out.println("1-Dosyadan veritabanına verileri aktar");
            System.out.println("2-Araba Ekle");
            System.out.println("3-Araba Güncelle");
            System.out.println("4-Araba Sil");
            System.out.println("5-Arabaları listele");
            input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    if (carRepository.databaseControl()) {
                        System.out.println("Veri tabanına veriler zaten kaydedilmiş durumda");
                    } else {
                        carRepository.saveAll(FileUtil.getCarList(FileUtil.readFile(Constant.carFile)));
                        System.out.println("Veriler Başarıyla kaydedildi");
                    }
                    break;
                default:
                    System.out.println("sayı girin");
                case 2:
                    carRepository.save(getCarInformation());
                case 3:
                    System.err.println("güncellemek istediğiniz arabnın idsini girin");
                    long updateId = Long.parseLong(scanner.nextLine());
                    carRepository.update(getCarInformation(), updateId);
                case 4:
                    System.err.println("silmek istediğiniz arabnın idsini girin");
                    long deletedetId = Long.parseLong(scanner.nextLine());
                    carRepository.delete(deletedetId);
                case 5:
                    carRepository.findAll().forEach(x-> System.out.println(x.toString()));
                    
            }
        } while (true);
    }

    public Car getCarInformation() {
        System.out.println("Lütfen Araba Markası girin");
        String brand = scanner.nextLine();

        System.out.println("Lütfen Araba Modelini girin");
        String carModel = scanner.nextLine();

        System.out.println("Lütfen Araba Yılını girin");
        String modelYear = scanner.nextLine();

        System.out.println("Lütfen Arabanın delar id sini girin");
        Long dealershipId = Long.parseLong(scanner.nextLine());

        return new Car(brand, carModel, modelYear, dealershipId);
    }
}
