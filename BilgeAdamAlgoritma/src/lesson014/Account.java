package lesson014;

public class Account {
	private String accountNo;
	private double money;
	private boolean KrediBasvurusu;
	private double istenenKredi;
	private double krediBorcu;
	private boolean KrediAlindiMi;
	private int krediNotu;
	private double nakitAvans;

	public Account() {
		this.accountNo = AccountManager.generateAccountID();
	}

	public Account(double money) {
		super();
		this.accountNo = AccountManager.generateAccountID();
		this.money = money;
	}

	public boolean isKrediBasvurusu() {
		return KrediBasvurusu;
	}

	public void setKrediBasvurusu(boolean krediBasvurusu) {
		KrediBasvurusu = krediBasvurusu;
	}

	public double getIstenenKredi() {
		return istenenKredi;
	}

	public void setIstenenKredi(double istenenKredi) {
		this.istenenKredi = istenenKredi;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public double getKrediBorcu() {
		return krediBorcu;
	}

	public void setKrediBorcu(double krediBorcu) {
		this.krediBorcu = krediBorcu;
	}

	public boolean isKrediAlindiMi() {
		return KrediAlindiMi;
	}

	public void setKrediAlindiMi(boolean krediAlindiMi) {
		KrediAlindiMi = krediAlindiMi;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public int getKrediNotu() {
		return krediNotu;
	}

	public void setKrediNotu(int krediNotu) {
		this.krediNotu = krediNotu;
	}

	public double getNakitAvans() {
		return nakitAvans;
	}

	public void setNakitAvans(double nakitAvans) {
		this.nakitAvans = nakitAvans;
	}

	@Override
	public String toString() {
		System.out.println();
		return "Hesap Numarası : " + accountNo + " Bakiye : " + money + " Kredi Başvurusu : " + KrediBasvurusu
				+ " İstenen Kredi (Varsa) : " + istenenKredi + " Kredi Borcu (Varsa) : " + krediBorcu + " Kredi Aldı mı ? " + KrediAlindiMi
				+ " Kredi Notu : " + krediNotu + " Nakit Avans : " + nakitAvans;
	}
	
	

//	public void depositMoney(double money) {
//		if (money <= 10000 && money > 0) {
//			this.setMoney(getMoney() + money);
//			System.out.println("İşlem Başarılı !! Yatırılan tutar : " + money);
//			System.out.println("Güncel Bakiyeniz : " + this.getMoney());
//		} else {
//			System.err.println("Lütfen bir seferde en fazla 10000 birim yatıeınız...!");
//		}
//	}
//
//	public void dwithdrawMoney(double money) {
//		if (this.getMoney() >= money) {
//			this.setMoney(getMoney() - money);
//			System.out.println("İşlem Başarılı !! Çekilen tutar : " + money);
//			System.out.println("Güncel Bakiyeniz : " + this.getMoney());
//		} else {
//			System.err.println("Bakiye yetersiz...!!");
//		}
//	}

}
