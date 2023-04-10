package com.yasinsolak.main;

import com.yasinsolak.entity.Car;
import com.yasinsolak.repository.CarRepository;
import com.yasinsolak.util.Constant;
import com.yasinsolak.util.DbConnection;
import com.yasinsolak.util.FileUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Manager {
    
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.menu();
        
    }
    private final CarRepository carRepository = new CarRepository();
    public void menu(){
        Car car = new Car("Lincoln","Continental","1992",9);
        carRepository.save(car);
        try {
            carRepository.saveAll(FileUtil.getCarList(FileUtil.readFile(Constant.carFile)));
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
