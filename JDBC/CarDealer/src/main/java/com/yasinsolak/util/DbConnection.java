package com.yasinsolak.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
    private static Connection connection;
    
    public static Connection createConnection(){
        
        try {
            connection = DriverManager.getConnection(Constant.url,Constant.username,Constant.password);
            System.out.println("Bağlantı Başarılı");
        } catch (SQLException ex) {
            System.out.println("Bağlantı Hatası");
        }
        return connection;
    }
    
}
