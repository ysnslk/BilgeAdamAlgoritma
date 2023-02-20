package lesson012;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Pizza Sipariş Uygulaması

		// Pizza Sınıfı
		// attribute ---> Price , vejeteryan mı ? Normal mi?
		// Eğer vejeteryan pizza ise fiyat 300 tl
		// Normal ise fiyat 200 TL

		/*
		 * 4 Metod Ekleyelim Sos ekle 50 TL Peynir Ekle 50 tl Eve sipariş ver 20 tl
		 * kurye parası Fis al -> Total fiyatı ver
		 */
		// mainde pizza oluşturalım.

		Pizza p1 = new Pizza(true);
		Pizza p2 = new Pizza(false);
		System.out.println(p1.isVeg());
		System.out.println(p1.getPrice());
		p1.sosEkle();
		System.out.println("Soslu : " + p1.getPrice());
		p1.peynirEkle();
		System.out.println("Peynirli : " + p1.getPrice());
		p1.eveSiparisVer();
		System.out.println("Eve Sipariş : " + p1.getPrice());
		p1.fisAl();
		menu();

	}

	// Kullanıcıdan vegi mi normal mi ?
	// Menu
	// 1-Sos Ekle
	// 2-Peynir Ekle
	// 3-Fiyatı Görüntüle
	// 4-Sos Çıkar
	// 5-PeynirÇıkar
	static Pizza pizza2;

	public static void menu() {

		Scanner sc = new Scanner(System.in);
		boolean isVegi = true;
		System.out.println("Pizzanızı Belirtin");
		// vegi
		// normal
		String pizzaTercih = sc.nextLine();
		if (pizzaTercih.equalsIgnoreCase("vegi")) {
			pizza2 = new Pizza(isVegi);
		} else {
			isVegi = false;
			pizza2 = new Pizza(isVegi);
		}

		boolean cikis = true;
		int sosSayac = 0;
		int peynirSayac = 0;
		while (cikis) {
			System.out.println("Seçim Yapın");
			System.out.println("Menu");
			System.out.println("1-Sos Ekle");
			System.out.println("2-Peynir Ekle");
			System.out.println("3-Sos Çıkar");
			System.out.println("4-Peynir Çıkar");
			System.out.println("5-Görüntüle");
			int secim = sc.nextInt();

			switch (secim) {
			case 1:
				pizza2.sosEkle();
				sosSayac++;
				break;
			case 2:
				pizza2.peynirEkle();
				peynirSayac++;
				break;
			case 3:
				if (sosSayac > 0) {

					pizza2.sosCikar();
					sosSayac--;
				} else {
					System.out.println("Sos yok");
				}
				break;
			case 4:
				if (peynirSayac > 0) {

					pizza2.peynirCikar();
					peynirSayac--;
				} else {
					System.out.println("Peynir yok");
				}
				break;

			case 5:
				pizza2.fisAl();
				// System.exit(0);
				cikis = false;
				break;

			default:
				System.out.println("Lütfen 1-3 Arası Sayı girin.");
				break;
			}
		}
	}

}
