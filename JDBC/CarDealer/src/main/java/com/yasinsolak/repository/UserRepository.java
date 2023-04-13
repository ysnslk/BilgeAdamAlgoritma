package com.yasinsolak.repository;

import com.yasinsolak.entity.User;
import com.yasinsolak.util.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRepository implements ICrud<User> {

    @Override
    public void save(User t) {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        try {
            String sql = "insert into users (name, email, phone, password,security_question,answer,address,isactive) values(?,?,?,?,?,?,?,?)";

            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, t.getName());
            preparedStatement.setString(2, t.getEmail());
            preparedStatement.setString(3, t.getPhone());
            preparedStatement.setString(4, t.getPassword());
            preparedStatement.setString(5, t.getSecurityQuestion());
            preparedStatement.setString(6, t.getAnswer());
            preparedStatement.setString(7, t.getAddress());
            preparedStatement.setBoolean(8, true);

            preparedStatement.executeUpdate();
            connection.commit();
            System.out.println(t.getName() + " isimli  kişi başrılya kaydedildi. ");

        } catch (SQLException ex) {
            Logger.getLogger(CarRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(User t, long id) {
        String sql = "update users set name=?, email=?, phone=?, password=?,security_question=?,answer=?,address=?";
        try {
            PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, t.getName());
            preparedStatement.setString(2, t.getEmail());
            preparedStatement.setString(3, t.getPhone());
            preparedStatement.setString(4, t.getPassword());
            preparedStatement.setString(5, t.getSecurityQuestion());
            preparedStatement.setString(6, t.getAnswer());
            preparedStatement.setString(7, t.getAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CarRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(long id) {
        String sql = "delete from users where id =?";
        try {

            PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CarRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users order by id";
        try {
            PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String phone = resultSet.getString(4);
                String password = resultSet.getString(5);
                String securtityQuestion = resultSet.getString(6);
                String answer = resultSet.getString(7);
                String address = resultSet.getString(8);

                User user = new User(id, name, email, phone, password, securtityQuestion, answer, address);
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    @Override
    public void saveAll(List<User> t) {
        //PreparedStatement preparedStatement = null;
        //Connection connection = null;
        String sql = "insert into users (name, email, phone, password,security_question,answer,address) values(?,?,?,?,?,?,?,?)";
        t.forEach(user -> {
            try {
                //Singleton DesignPAttern nedir neden kullanırız.
                //JDBC database Singelton connection 
                //connection.setAutoCommit(false);
                PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getPhone());
                preparedStatement.setString(4, user.getPassword());
                preparedStatement.setString(5, user.getSecurityQuestion());
                preparedStatement.setString(6, user.getAnswer());
                preparedStatement.setString(7, user.getAddress());

                preparedStatement.executeUpdate();
                //connection.commit();

            } catch (SQLException ex) {
                Logger.getLogger(CarRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public boolean databaseControl() {
        boolean control = false;
        String sql = "select * from user";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            control = resultSet.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return control;
    }

}
