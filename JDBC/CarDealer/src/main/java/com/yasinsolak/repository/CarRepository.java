package com.yasinsolak.repository;

import com.yasinsolak.entity.Car;
import com.yasinsolak.util.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarRepository implements ICrud<Car> {

    @Override
    public void save(Car t) {

        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            String sql = "insert into car (brand,car_model,model_year,dealership_id) values(?,?,?,?)";
            connection = DbConnection.createConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, t.getBrand());
            preparedStatement.setString(2, t.getCarModel());
            preparedStatement.setString(3, t.getModelYear());
            preparedStatement.setLong(4, t.getDealerShipId());
            preparedStatement.executeUpdate();
            connection.commit();
            System.out.println(t.getBrand() + " Başarı ile kaydedildi.");
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Car t, long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Car> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void saveAll(List<Car> t) {

        //PreparedStatement preparedStatement = null;
       // Connection connection = null;
//JDBC singelton connection
        String sql = "insert into car (brand,car_model,model_year,dealership_id,id) values(?,?,?,?,?)";
        t.forEach(c -> {
            try {
                PreparedStatement preparedStatement = DbConnection.createConnection().prepareStatement(sql);
                //connection.setAutoCommit(false);
               // preparedStatement = connection.prepareCall(sql);
                preparedStatement.setString(1, c.getBrand());
                preparedStatement.setString(2, c.getCarModel());
                preparedStatement.setString(3, c.getModelYear());
                preparedStatement.setLong(4, c.getDealerShipId());
                preparedStatement.setLong(5, c.getId());
                preparedStatement.executeUpdate();
               // connection.commit();
            } catch (SQLException ex) {
                Logger.getLogger(CarRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

}
