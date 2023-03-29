package com.bilgeadam.util;

import java.sql.*;

public class JDBCHelper {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(JDBCConstant.URL, JDBCConstant.USERNAME, JDBCConstant.PASSWORD);
        return connection;
    }

    public static void closeConnection(Connection connection){
        if(connection!= null){
            try{
                connection.close();
            }catch (SQLException e){
                throw new RuntimeException();
            }
        }
    }

    public static void closePrepareStatement(PreparedStatement preparedStatement){
        if(preparedStatement!= null){
            try{
                preparedStatement.close();
            }catch (SQLException e){
                throw new RuntimeException();
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet){
        if(resultSet!= null){
            try{
                resultSet.close();
            }catch (SQLException e){
                throw new RuntimeException();
            }
        }
    }


}
