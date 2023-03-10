package lesson014;

public class Main {

	public static void main(String[] args) {
		/*
		 * Account sınıfımız olsun accountNo,money
		 * 
		 * parayatir() paraCek()
		 *
		 * AccountManager sınfıı aç para işlemlerini aktar
		 *
		 * AccountManager de bilgileri göster metodu yazalım.
		 *
		 * User sınıfı
		 *
		 * Kullanıcıdan aldığımız değerler ile otomatik @banka.com uzantılı mail
		 * üretelim.
		 * 
		 * User olarak kredi başvurusunda bulunalım. Krediyi çekeceği account u ve ne
		 * kadar kredi istiyor miktar private boolean krediBasvurusu private double
		 * istenenKrediMiktari krediBasvurusundaBulun() ---> Account , int para
		 * 
		 * AdminManager Sayfası oluşturalım. kredibasvurusunu onayla Bizim hesabımıza
		 * çekmek istediğimiz kadar para hesaba aktarılacak
		 * 
		 * ----------
		 * 
		 * krediBorcunuOde() hesaptan öde , nakit ödeme eğer userin çekmiş olduğu
		 * kredi yoksa ve ya kredi borcu reddedilmiş ise işlemleri gerçekleştiriyoruz
		 * 
		 * çekilmiş kredi varsa paramtre olarak girdiğimiz kadar ödeme yapmış olalım
		 * kredi kartı borcunu düşürsün
		 * 
		 * Çıktı olarak -> Güncel kredi kartı borcunuz .... TL
		 */
		AccountManager accountManager = new AccountManager();
		UserManager userManager = new UserManager();
		AdminManager adminManager = new AdminManager();

		Account a1 = new Account();
		a1.setMoney(1000);

		System.out.println("*****");

		Account a2 = new Account(25000);

		accountManager.depositMoney(a1, 1000);
		accountManager.depositMoney(a1, 500);
		accountManager.dwithdrawMoney(a1, 500);
		System.out.println("*************");
		accountManager.accountDetails(a1);
		accountManager.accountDetails(a2);

		User u1 = new User();
		u1.setName("Yasin");
		u1.setSurName("Solak");
		u1.setEmail("aaa@gmail.com");
		u1.setAccount(a2);
		System.out.println(u1);

		User u3 = new User("Ali Mehmet", "Kaya", a2);
		userManager.generateAutoEmail(u3);

		System.out.println(u3.getEmail());

		Account acc1 = new Account();
		acc1.setMoney(10000);

		Account acc2 = new Account();
		acc2.setMoney(10000);

		Account acc3 = new Account();
		acc3.setMoney(100000);

		User us1 = new User();
		us1.setName("Yasin");
		us1.setSurName("Solak");
		us1.setEmail("aaa@gmail.com");
		us1.setAccount(acc1);

		User us2 = new User();
		us2.setName("Yasin");
		us2.setSurName("Solak");
		us2.setEmail("aaa@gmail.com");
		us2.setAccount(acc2);

		User us3 = new User();
		us3.setName("Yasin");
		us3.setSurName("Solak");
		us3.setEmail("aaa@gmail.com");
		us3.setAccount(acc3);

		adminManager.krediBasvursunuOnayla(acc1);
		System.out.println(acc3.getMoney());
		userManager.getCredit(acc3, 10000);
		adminManager.krediBasvursunuOnayla(acc3);
		System.out.println(acc3.getMoney());

		Account ac5 = new Account();
		ac5.setMoney(25000);
		System.out.println(ac5.getAccountNo());
		
		System.out.println("************\n");
		System.out.println("Hesap Bakiye : "+acc3.getMoney());
		System.out.println(acc3.getKrediBorcu());
		us3.krediBorcunuOde(acc3,1000);
		us3.hesaptanKrediBorcunuOde(acc3,100);
		us3.hesaptanKrediBorcunuOde(acc3,100);
		us3.hesaptanKrediBorcunuOde(acc3,100);
		us3.hesaptanKrediBorcunuOde(acc3,100);
		us3.hesaptanKrediBorcunuOde(acc3,100);
		System.out.println(acc3.getKrediNotu());
		us3.nakitAvansCek(acc3);
		us3.nakitAvansCek(acc3);
		
		System.out.println(us3);
		
	}

}
