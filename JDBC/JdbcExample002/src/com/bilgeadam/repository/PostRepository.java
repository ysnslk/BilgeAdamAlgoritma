package com.bilgeadam.repository;

import com.bilgeadam.util.JDBCHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRepository {

    public void getAllTweet(){
        String sql = "select first_name, description  from posts join persons on posts.person_id = persons.id";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = JDBCHelper.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            displayPersons(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void displayPersons(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("description"));
        }
    }
}