package lesson023.entity.database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lesson023.entity.data.User;

public class DataBase {

	private static List<User> userList = new ArrayList<>();

	public DataBase() {
		userList.add(new User("123", "alikaya@gmail.com", "123456", "alikaya", LocalDate.now()));
		userList.add(new User("555", "velikaya@gmail.com", "123456", "velikaya", LocalDate.now()));
		userList.add(new User("666", "ayseseker@gmail.com", "123456", "ayseseker", LocalDate.now()));
		userList.add(new User("777", "ahmetsen@gmail.com", "123456", "ahmetsen", LocalDate.now()));
	}

	public static List<User> getUserList() {
		return userList;
	}

	public static void setUserList(List<User> userList) {
		DataBase.userList = userList;
	}

}
