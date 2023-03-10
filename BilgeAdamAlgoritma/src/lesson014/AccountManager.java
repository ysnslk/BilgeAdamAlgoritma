package lesson014;

import java.util.Random;

public class AccountManager {
	public void depositMoney(Account account, double money) {
		if (money <= 10000 && money > 0) {
			account.setMoney(account.getMoney() + money);
			System.out.println("İşlem Başarılı !! Yatırılan tutar : " + money);
			System.out.println("Güncel Bakiyeniz : " + account.getMoney());
		} else {
			System.err.println("Lütfen bir seferde en fazla 10000 birim yatıeınız...!");
		}
	}

	public void dwithdrawMoney(Account account, double money) {
		if (account.getMoney() >= money) {
			account.setMoney(account.getMoney() - money);
			System.out.println("İşlem Başarılı !! Çekilen tutar : " + money);
			System.out.println("Güncel Bakiyeniz : " + account.getMoney());
		} else {
			System.err.println("Bakiye yetersiz...!!");
		}
	}

	public void accountDetails(Account account) {
		System.out.println("Hesap Numaranız : " + account.getAccountNo() + " Güncel Bakiyeniz : " + account.getMoney());
	}
	
	public static String generateAccountID() {
		Random rnd = new Random();
		Long random = rnd.nextLong(1000,10000);
		String stringID = String.valueOf(random);
		return stringID;
	}
}
