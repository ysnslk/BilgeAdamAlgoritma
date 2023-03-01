package lesson016;

public class Main {
	static Kutuphane kutuphane = new Kutuphane("Milli Kütüphane");

	public static void main(String[] args) {
		/*
		 * Kitap sınıfımız olsun isim , yazar , fiyat
		 *
		 *
		 * Kütüphane isim,Kitaplar
		 *
		 * IKutuphaneManager interface interface kitapEkle
		 *
		 * Util sınıfı oluştur intDegerAl() stringDegerAl()
		 *
		 *
		 * Kullanıcıdan aldığımız isim yazar ve fiyatla bir kitap nesnesi oluşturalım
		 * 
		 * kitaplariListele----> İsmini ve fiyatını yazsın
		 * 
		 * kitapSil ----->
		 * 
		 * indirimYap metodu kitap ismini alalım. Alınan isimde bir kitap yoksa kitap
		 * yoktur kitabın fiyatını güncelleyin güncel fiyatı yazın
		 * 
		 * Kontrol diye bir metod yazarız. Kitap var mı yok mu onu bulur. Varsa o kitabı
		 * bize return eder. Yoksa Bilglilendirir.
		 * 
		 * 
		 * Kitabı güncelle metodu
		 * 
		 * İndirimde olan kitapları listele
		 */

		adminMenu();

	}

	public static void adminMenu() {

		while (true) {
			System.out.println("1-Kitap Ekle");
			System.out.println("2-Bütün Kitapları Listele");
			System.out.println("3-Yazarın Kitaplarını Listele");
			System.out.println("4-Kitap Sil");
			System.out.println("5-İndirim Yap");
			System.out.println("6-Kitap Güncelle");
			System.out.println("7-İndirimde Olan Kitapları Goster");
			int secim = Util.intDegerAl("Seçiminiz: ");
			switch (secim) {
			case 1:
				kutuphane.kitapEkle();
				break;
			case 2:
				kutuphane.kitaplariListele();
				break;
			case 3:
				kutuphane.yazarIleArama();
				break;
			case 4:
				kutuphane.kitapSil();
				break;
			case 5:
				kutuphane.indirimYap();
				break;
			case 6:
				kutuphane.kitabıGuncelle();
				break;
			case 7:
				kutuphane.indirimdekiKitaplariListele();
				break;
			default:
				System.out.println("Lütfen Dogru seçin yapın!!!!");
				break;
			}
		}
	}
}
