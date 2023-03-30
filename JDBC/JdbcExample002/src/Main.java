import com.bilgeadam.controller.PersonController;
import com.bilgeadam.entity.Person;
import com.bilgeadam.repository.PersonRepository;
import com.bilgeadam.util.Menu;

import java.util.Date;

public class Main {

    /*
        1- personDb adından db oluşturalım. id first_name last_name joined_date
        person sınıfı oluşturalım.

        2- Util paketine JDBCHepler diye bir class oluşturalım
        getConnection() diye bir metod yazalım

        Database bilgilerini farklı bir sınıftan çekelim
        JDBCConstant diye bir sınıf oluşturalım. Db bilgilerini burada tanıtalım

        3- Repository katmanına insertPerson metodunu yazalım. Parametre olarak person nesnesi alsın

        4- getAllPersons() ;


        ------------ HW ------------------

        5- deleteAllRecords();

        6- updateEmail(String email , int id); --> transaction

        7- getPersonById(int id);

        8- deletePerson(int id); --> transaction

        menu (Util)

     */
    public static void main(String[] args) {
        /*
           PersonRepository p = new PersonRepository();
           Person person = new Person("Ahmet ","Şekerci","sad@gmail.com",new Date());
           p.insertPerson(person);
           p.getAllPersons();

            PersonController personController = new PersonController();
            Person person = new Person("Ali ","Kaya","ak@gmail.com",new Date());
            personController.insertPerson(person);
            personController.getAllPerson();
            personController.deleteAllRecords();
            System.out.println("\n-----------\n");
            personController.getPersonById(7);
            personController.updateEmail("asdsa@gmail.com" , 7);
            personController.getPersonById(7);
            personController.deletePersonById(8);
            System.out.println("\n-----------\n");
            personController.getAllPerson();
        */
        Menu menu = new Menu();
        menu.menu();
    }
}

/*
Transaction --> Bir run time exceptionda verilen database yazılmasını saglar

Banka hesabınızda bir para çıkışı olması laızm
gönder butonunda bastıktan sonra hata olursa iki işlemide geri alır
 */