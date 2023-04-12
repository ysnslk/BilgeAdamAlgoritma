package com.yasinsolak.util;

import com.yasinsolak.entity.Car;
import com.yasinsolak.entity.Dealership;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.dynalink.beans.StaticClass;

public class FileUtil {

    /*
        readFile() metodu yazalım    parametre olarak string path
        getCarList() metodu yazalım  parametre olarak list alsın
     */
    public static List<String> readFile(String path) throws IOException {
        List<String> result = new ArrayList<>();
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(path));

            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return result;
    }

    public static List<Car> getCarList(List<String> list) {

        List<Car> cars = new ArrayList<>();
        for (String string : list) {
            cars.add(convertToCar(string.split(",")));
        }
        return cars;
    }

    public static Car convertToCar(String[] array) {
        Car car = new Car(Long.parseLong(array[0]), array[1], array[2], array[3], Long.parseLong(array[4]));
        return car;
    }

    public static List<Dealership> getDealershipList(List<String> list) {

        List<Dealership> dealerships = new ArrayList<>();
        for (String string : list) {
            dealerships.add(convertToDealership(string.split(",")));
        }
        return dealerships;
    }

    public static Dealership convertToDealership(String[] array) {
        Dealership dealership = new Dealership(Long.parseLong(array[0]), array[1], array[2], array[3]);
        return dealership;
    }

    public static void main(String[] args) {
        List<Car> list;
        try {
            list = getCarList(readFile(Constant.carFile));
            for (Car car : list) {
                System.out.println(car);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
