package lesson014;

import java.awt.AlphaComposite;

public class User {

	private String name;
	private String surName;
	private String email;
	private Account account;

	public User() {
	}

	public User(String name, String surName, Account account) {
		this.name = name;
		this.surName = surName;
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void hesaptanKrediBorcunuOde(Account account, double money) {
		if (account.isKrediAlindiMi()) {
			if (account.getKrediBorcu() >= money) {
				if (account.getMoney() >= money) {
					account.setKrediBorcu(account.getKrediBorcu() - money);
					account.setMoney(account.getMoney() - money);
					System.out.println("Kredi borcunuzua " + money + " tutarı kadar ödeme yaptınız");
					System.out.println("Güncel Borcunuz : " + account.getKrediBorcu());
					System.out.println("Güncel Bakiyeniz : " + account.getMoney());
					account.setKrediNotu(account.getKrediNotu() + 10);
				} else {
					System.out.println("Bu işlem için bakiyeniz yetersiz.");
				}
			} else {
				double fazlaMiktar = money - account.getKrediBorcu();
				account.setMoney(account.getMoney() + fazlaMiktar);
				System.out
						.println("Yatırdığınız tutar kredi tutarından fazladır. Fazla tutar hesabınıza aktarılmıştır.");
				System.out.println("Aktarılan tutar : " + fazlaMiktar);
				System.out.println("Güncel Bakiyeniz : " + account.getMoney());
				account.setKrediNotu(account.getKrediNotu() + 50);

			}
		} else {
			System.out.println("İşleminizi gerçekleştiremiyoruz");
		}
	}

	public void krediBorcunuOde(Account account, double taksit) {
		if (account.isKrediAlindiMi()) {
			if (taksit < account.getKrediBorcu()) {
				account.setKrediBorcu(account.getKrediBorcu() - taksit);
				account.setMoney(account.getMoney() - taksit);
				System.out.println("Kredi borcunuzua " + taksit + " tutarı kadar ödeme yaptınız");
				System.out.println("Güncel Borcunuz : " + account.getKrediBorcu());
				account.setKrediNotu(account.getKrediNotu() + 10);
			} else {
				System.err.println("Kredi tutarınızdan büyük taksit yatıramazsınız");
			}
		} else {
			System.err.println("İşleminizi gerçekleştiremiyoruz");
		}
	}

	public void nakitAvansCek(Account account) {
		if (account.getKrediNotu() >= 50) {
			double nakitAvans = (account.getMoney() / 2);
			account.setMoney(account.getMoney() - nakitAvans);
			account.setNakitAvans(account.getNakitAvans() + nakitAvans);
			System.out.println("Nakit avans çekilmiştir. Çekilen tutar : " + account.getNakitAvans());
			System.out.println("Güncel Bakiyeniz : " + account.getMoney());
		} else {
			System.err.println("Kredi notunuz 50 den küçüktür.Nakit avans çekemezsiniz...!");
			System.out.println("Kredi Notunuz : "+account.getKrediNotu());
		}
	}

	@Override
	public String toString() {
		System.out.println();
		System.out.println("Kullanıcı Bilgileri : ");
		return "Adı : " + name + " Soyadı : " + surName + " Mail Adresi : " + email + " \n\nHesabı :\n\n" + account;
	}

}
