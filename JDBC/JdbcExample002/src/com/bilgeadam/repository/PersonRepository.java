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
        String query = "Select * from persons";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCHelper.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            displayPersons(resultSet);

        } catch (SQLException e) {

            throw new RuntimeException(e);
        } finally {
            JDBCHelper.closeConnection(connection);
            JDBCHelper.closePrepareStatement(preparedStatement);
            JDBCHelper.closeResultSet(resultSet);
        }

    }



}
