package com.bilgeadam.controller;

import com.bilgeadam.entity.Person;
import com.bilgeadam.service.PersonService;

public class PersonController {

    private final PersonService personService;

    public PersonController() {
        this.personService = new PersonService();
    }

    public void insertPerson(Person person) {
        personService.insertPerson(person);
    }

    public void getAllPerson(){
        personService.getAllPerson();
    }

    public void updateEmail(String email , int id){
        personService.updateEmail( email , id);
    }

    public void deleteAllRecords(){
    personService.deleteAllRecords();
    }

    public void getPersonById(int id){
        personService.getPersonById(id);
    }

    public void deletePersonById(int id){
        personService.deletePersonById(id);
    }

}
