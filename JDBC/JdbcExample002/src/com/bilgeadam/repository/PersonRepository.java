package com.bilgeadam.repository;

import com.bilgeadam.entity.Person;
import com.bilgeadam.util.JDBCHelper;

import java.sql.*;

public class PersonRepository implements  IPersonRepository{

    @Override
    public void insertPerson(Person person) {
        String query = "insert into persons (first_name,last_name,email,joined_date) values(?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCHelper.getConnection();

            //Transaction için otomatik yazmayı kapattık
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, person.getFirst_name());
            preparedStatement.setString(2, person.getLast_name());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.setDate(4, new Date(person.getJoined_date().getTime()));
            int effectedRow = preparedStatement.executeUpdate();
            connection.commit();
            if (effectedRow > 0) {
                System.out.println(person.getFirst_name() + " " + person.getLast_name() + " Veri Tabanına Eklendi");
            }
        } catch (SQLException e) {
            System.out.println("Kayıt sırasında bir hata oluştu");
            throw new RuntimeException();
        } finally {
            JDBCHelper.closeConnection(connection);
            JDBCHelper.closePrepareStatement(preparedStatement);
        }
    }

    private void displayPersons( ResultSet resultSet) throws SQLException {

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            java.util.Date joined_date = resultSet.getDate("joined_date");
            System.out.println(id + "," + first_name + "," + last_name + "," + email + "," + joined_date);
        }

    }
    @Override
    public void getAllPerson() {
        Connection connection = null;
        String query = "Select * from persons ";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCHelper.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
           if(resultSet != null){
                displayPersons(resultSet);
            }
            else {
               System.out.println("Tabloda kayıtlı veri bulunamadı....!");
            }


        } catch (SQLException e) {

            throw new RuntimeException(e);
        } finally {
            JDBCHelper.closeConnection(connection);
            JDBCHelper.closePrepareStatement(preparedStatement);
            JDBCHelper.closeResultSet(resultSet);
        }

    }
    @Override
    public void deleteAllRecords(){
        String query = "Delete from persons returning *";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCHelper.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeQuery();
            System.out.println("Kayıtlar Başarı ile silindi!!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCHelper.closeConnection(connection);
            JDBCHelper.closePrepareStatement(preparedStatement);
        }


    }

    @Override
    public void getPersonById(int id) {
        Connection connection = null;
        String query = "Select * from persons where id ="+id+"";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCHelper.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            // if(resultSet.first() != true){
            displayPersons(resultSet);
        } catch (SQLException e) {

            throw new RuntimeException(e);
        } finally {
            JDBCHelper.closeConnection(connection);
            JDBCHelper.closePrepareStatement(preparedStatement);
            JDBCHelper.closeResultSet(resultSet);
        }
    }

    @Override
    public void deletePersonById(int id) {
        String query = "Delete from persons where id=? returning *";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCHelper.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            connection.commit();
            System.out.println("Kayıt Başarı ile silindi!!!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCHelper.closeConnection(connection);
            JDBCHelper.closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void updateEmail(String email, int id) {
        String query = "UPDATE persons set email = ? where id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JDBCHelper.getConnection();

            //Transaction için otomatik yazmayı kapattık
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,email);
            preparedStatement.setInt(2, id);
            int effectedRow = preparedStatement.executeUpdate();
            connection.commit();
            if (effectedRow > 0) {
                System.out.println(id + "li kullanıcının mai adresi veri tabanında güncellendi");
            }
        } catch (SQLException e) {
            System.out.println("Kayıt sırasında bir hata oluştu");
            throw new RuntimeException();
        } finally {
            JDBCHelper.closeConnection(connection);
            JDBCHelper.closePrepareStatement(preparedStatement);
        }
    }
}
