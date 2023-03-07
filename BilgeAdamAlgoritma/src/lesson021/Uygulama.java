package lesson021;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Uygulama {

	/*
	 * 1- Yük yeri seçme metodumuz olsun.
	 * 
	 * Bu metod limandaki yükler arrayinden bir yer belirlesin Eğer sınırdan fazla
	 * ise hata fırlatsın.
	 * 
	 * 
	 * 2- Kendi exception sınıfımızı oluşturalım
	 * 
	 * LimanAppException , Daha sonra seçtiğimiz yer null değilse hata fırlatıcaz.
	 * kendi yazdığımız exception sınıfımızı throw edice
	 * 
	 * 
	 * 3- Hata mesajları için Enum Sınıfı olşuturalım
	 * 
	 * ErrorType -> Hata mesajının kodu, mesaj kısmı olsun
	 *
	 *
	 * 4-Ağırlık belirle Metodu --> Limanımız 100 kilo altı yükleri kabul etmesin
	 *
	 * double dönsün
	 *
	 *
	 * 5- Limanımız cuma günleri ürün kabul etmiyor
	 */

	Liman liman;
	static Scanner sc = new Scanner(System.in);

	public Uygulama() {
		this.liman = new Liman();
	}

	public void yukYeriSec() {
		System.out.println("Lütfen bir yük yeri seçin");
		int index = sc.nextInt();
		try {
			Yuk yuk = liman.getYukler()[index];
		} catch (Exception e) {
			System.out.println("Lütfen sınırlar dahilinde bir yer seçin");
		}
	}

	// 0 ile yukler arrayimiz kadar bu aralıkta bir yer seçmemizi için override
	// edelim
	// int deger donsun
	public int yukYeriSec2() {
		liman.getYukler()[0] = new Yuk("Tv", 150, LocalDate.now());
		System.out.println("Lütfen bir yük yeri seçin");
		int index = sc.nextInt();
		if (index < 0 || index >= liman.getYukler().length) {
			throw new LimanAppException(ErrorType.OUT_OF_BOUNDS);
		} else if (liman.getYukler()[index] != null) {
			throw new LimanAppException(ErrorType.SEAT_ALREADY_OCCUPIED);
		}
		return index;
	}

	public double agirlikAl() {
		double weight = Util.doubleDegerAlma("Yükün ağırlığını girin");
		if (weight < 100) {
			throw new LimanAppException(ErrorType.TOO_LOW_WEIGHT);
		}

		return weight;
	}

	public LocalDate kabulTarihKontrol() {
		// Geçmişteki bir tarih aldığımızda hata fırlatmamız lazım
		LocalDate date = Util.stringTarih();

		if (date.isBefore(LocalDate.now())) {
			throw new LimanAppException(ErrorType.EXPIRED_DATE);
		} else if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
			throw new LimanAppException(ErrorType.OUT_OF_SHIFT_DAY);
		}
		return date;
	}

	public void yukOlustur() {
		Yuk yuk = null;
		int index = 0;
		try {
			index = yukYeriSec2();
			String name = Util.stringDegerAl("İsim");
			double agirlik = agirlikAl();
			LocalDate kabulTarih = kabulTarihKontrol();
			yuk = new Yuk(name, agirlik, kabulTarih);
			liman.getYukler()[index] = yuk;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			if(yuk == null) {
				System.out.println("Yükünüz kabul edilmedi..!");
			}
			else {
				System.out.println("Yükünüz kabul edilmiştir. "+index+" no lu yere yerleşti");
			}
		}
	}

	public static void main(String[] args) {
		Uygulama uygulama = new Uygulama();
//		try {
//			uygulama.yukYeriSec2();
//			uygulama.agirlikAl();
//			uygulama.kabulTarihKontrol();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		uygulama.yukOlustur();
		System.out.println("--");
	}

}
