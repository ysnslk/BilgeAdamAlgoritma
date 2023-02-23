package lesson014;

public class UserManager {

	private final String emailFormat = "@xbanka.com";

	public void generateAutoEmail(User user) {

		user.setEmail(user.getName().toLowerCase().replace(" ", ".") + '.'
				+ user.getSurName().toLowerCase().replace(" ", ".") + emailFormat);
	}
	
	
	public void getCredit(Account account,int money) {
		account.setKrediBasvurusu(true);
		account.setIstenenKredi(money);
		
		System.out.println(money+" miktarda krediye başvurdunuz...");
		System.out.println("Lütfen Onay Bekleyin");
	}
	
	

//	public void otomatikEmailOlustur(User user) {
//		String otomatikOlusanEmail = user.getName().toLowerCase().replaceAll(" ", ("."))
//		.concat("." + user.getSurname().toLowerCase().replace(' ', ('.'))) + emailFormat;user.setEmail(otomatikOlusanEmail);     
//		}
}
