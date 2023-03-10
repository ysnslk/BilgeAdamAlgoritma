package lesson014;

public class AdminManager {

	public void krediBasvursunuOnayla(Account account) {
		if (account.isKrediBasvurusu()) {
			System.out.println("Kredi başvurunuz onaylanmıştır");
			account.setMoney(account.getMoney() + account.getIstenenKredi());
			account.setKrediBorcu(account.getIstenenKredi());
			account.setKrediBasvurusu(false);
			account.setIstenenKredi(0);
			account.setKrediAlindiMi(true);
		} else {
			System.err.println("Kredi başvurunuz bulunmamaktadır");
		}
	}

	public void krediBasvursunuReddet(Account account) {
		if (account.isKrediBasvurusu()) {
			System.out.println("Kredi başvurunuz reddedildi");
			account.setIstenenKredi(0);
			account.setKrediBasvurusu(false);
		} else {
			System.err.println("Kredi başvurunuz bulunmamaktadır");
		}
	}

//	public void krediBasvurusunuOnayla(User user) {
//		// Kredi başvurusu var mı yok mu?
//		 if (user.getAccount().isKrediBasvurusu()) {
//		 System.out.println("Kredi Başvurnuz Onaylanmıştır. ");
//		user.getAccount().setMoney(user.getAccount().getMoney() + user.getAccount().getIstenenKredi());
//		user.getAccount().setKrediBasvurusu(false);
//		} else {
//		 System.out.println("Kredi Başvurusu Yok");
//		        }
//		    }
}
