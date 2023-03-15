package lesson023.service;

import java.time.LocalDate;
import java.util.Random;

import lesson023.entity.data.User;
import lesson023.entity.database.DataBase;
import lesson023.util.Util;

public class UserManager {

	DataBase dataBase;
	
	public UserManager() {
		dataBase = new DataBase();
	}

	public User userMailKontrol(String mail) {
		for (int i = 0; i < DataBase.getUserList().size(); i++) {
			if (DataBase.getUserList().get(i).getEmail().equals(mail)) {
				return DataBase.getUserList().get(i);
			}
		}
		System.out.println("User Bulunamadı");
		return null;
	}
	//void bir değer döndürmeyen metotlar
	public boolean userSifreKontrol(String password) {
		for (int i = 0; i < DataBase.getUserList().size(); i++) {
			if (DataBase.getUserList().get(i).getPassword().equals(password)) {
				return true;
			}
		}
		System.out.println("Şifre Yanlış");
		return false;
	}
	
	//SOLID
	//S-> single Resposnibilities
	public void register() {
		String email = Util.stringDegerAl("Mail: ");
		String password = Util.stringDegerAl("Password: ");
		String name = Util.stringDegerAl("Name: ");
		LocalDate birthDay = Util.stringTarih();
		User user = new User(email, password, name, birthDay);
		String id = activationCode();
		System.out.println("Activasyon Kodunuz: "+id);
		String aktivasyonKodu = Util.stringDegerAl("Lütfen kodu doğru giriniz");
		if(id.equals(aktivasyonKodu)) {
			DataBase.getUserList().add(user);
		}else {
			System.out.println("Aktivasyon kodunuz yanlış girdiniz: ");
		}
	}
	
	private String activationCode() {
		Random random = new Random();
		int activateCode = random.nextInt(1000,5000);
		String id = Integer.toString(activateCode);
		return id;
	}
}