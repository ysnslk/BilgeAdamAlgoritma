package lesson023.service;

import lesson023.entity.data.User;
import lesson023.entity.database.DataBase;

public class UserManager {

	// Kullanıcının girdiği mail bizim db mizde var mı ?
	// Varsa useri return edelim
	
	DataBase database;
	
	public UserManager() {
		database = new DataBase();
	}

	public User userKontrol(String mail) {

		for (int i = 0; i < DataBase.getUserList().size(); i++) {
			if (DataBase.getUserList().get(i).getEmail().equals(mail)) {
				return DataBase.getUserList().get(i);
			}
		}
		System.out.println("User Bulunamadı...");
		return null;

	}
	
	public boolean userSifreKontrol(String password) {

		for (int i = 0; i < DataBase.getUserList().size(); i++) {
			if (DataBase.getUserList().get(i).getPassword().equals(password)) {
				return true;
			}
		}
		System.out.println("Şifre Yanlış...");
		return false;

	}

}
