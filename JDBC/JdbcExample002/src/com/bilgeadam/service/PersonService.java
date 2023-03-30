package com.bilgeadam.service;

import com.bilgeadam.entity.Person;
import com.bilgeadam.repository.PersonRepository;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService() {
       this.personRepository = new PersonRepository();
    }

    public void insertPerson(Person person){
        if(person.getEmail().contains("@")){
            personRepository.insertPerson(person);
        }else {
            System.out.println("Lütfen bilgileri kontrol ediniz");
        }
    }

    public void getAllPerson() {
    personRepository.getAllPerson();
    }

    public void deleteAllRecords() {
        personRepository.deleteAllRecords();
    }

    public void getPersonById(int id) {
        personRepository.getPersonById(id);
    }

    public void deletePersonById(int id) {
        personRepository.deletePersonById(id);
    }

    public void updateEmail(String email, int id) {
        personRepository.updateEmail(email,id);
    }
}
