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
		int key = Util.intDegerAlma("Yapmak istediğiniz işlem: ");
		switch (key) {
		case 1:
			adminMenu();
			break;
		case 2:
			userLogin();
			break;
		case 3:
			userManager.register();
			break;

		default:
			break;
		}
	}

	private void adminMenu() {
		System.out.println("1- Tüm Kullanıcıları Listele");
		System.out.println("2- Ana Menu");
		int key = Util.intDegerAlma("Yapmak istediğiniz işlem: ");
		switch (key) {
		case 1:
			System.out.println("Kullanıcılar listelendi");
			break;
		case 2:
			break;
		default:
			break;
		}
	}

	private void userLogin() {
		String mail = Util.stringDegerAl("Mail: ");
		String password = Util.stringDegerAl("Password: ");

		User user = userManager.userMailKontrol(mail);
		boolean kontrol = userManager.userSifreKontrol(password);
		if (user != null && kontrol) {
			System.out.println(user.getId());
			userMenu(user);
		}
		
	}

	private void userMenu(User user) {
		System.out.println("1- DM At");
		int key = Util.intDegerAlma("Yapmak istediğiniz işlem: ");
		switch (key) {
		case 1:
			System.out.println("Dm Atıldı " + user.getEmail());
			break;
		case 2:
			break;
		default:
			break;
		}
	}
	
	//UserExcepiton sınıfı
}