package com.bilgeadam.repository;

import com.bilgeadam.entity.Person;

public interface IPersonRepository {

    public void insertPerson(Person person);
    public void getAllPerson();

    public void deleteAllRecords();

    public void getPersonById(int id);

    public void deletePersonById(int id);

    public void updateEmail(String email, int id);


}
