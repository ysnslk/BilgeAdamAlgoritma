package com.yasinsolak.xml.databaseornek;

public class DatabaseService {

    IDatabase iDatabase;

    public DatabaseService(IDatabase iDatabase){
        this.iDatabase = iDatabase;
    }

    public void logToDatabase(){
        iDatabase.lotToDatabase();
    }
}
