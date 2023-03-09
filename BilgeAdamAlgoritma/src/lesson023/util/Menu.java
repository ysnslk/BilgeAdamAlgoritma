package lesson023.util;

import lesson023.entity.data.User;
import lesson023.service.UserManager;

public class Menu {

	UserManager userManager;

	public Menu() {
		userManager = new UserManager();
	}

	public void menu() {
		System.out.println("1- Admin Menu");
		System.out.println("2- User İşlemleri");
		System.out.println("3- Kayıt Ol");
		int key = Util.intDegerAlma("Yapmak istediğiniz işlem");
		switch (key) {
		case 1:
			adminMenu();
			break;
		case 2:
			userLogin();
			break;

		default:
			break;
		}
	}

	private void adminMenu() {
		System.out.println("1-Tüm Kullanıcılar Listele");
		System.out.println("2-Ana Menu");
		int key = Util.intDegerAlma("Yapmak istediğiniz işlem");
		switch (key) {
		case 1:
			System.out.println("Kullanıcılar Listelendi");
			break;
		case 2:
			menu();
			break;
		default:
			break;
		}
	}

	private void userLogin() {
		String mail = Util.stringDegerAl("Mail adresinizi girin");
		String password = Util.stringDegerAl("Şifrenizi girin");

		User user = userManager.userKontrol(mail);
		boolean pass = userManager.userSifreKontrol(password);
		if (user != null && pass) {
			userMenu(user);
		}

	}

	private void userMenu(User user) {
		System.out.println("1- Dm At");
		int key = Util.intDegerAlma("Yapmak istediğiniz işlem");
		switch (key) {
		case 1:
			System.out.println("Dm Atıldı");
			break;

		default:
			break;
		}
	}

}

//UserException
