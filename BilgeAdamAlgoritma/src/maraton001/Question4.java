package maraton001;

import java.util.Scanner;

public class Question4 {
	public static Scanner sc = new Scanner(System.in); // Çalışıyor fakat Javada bu şekilde tanımlamak mantıklı mı
														// bilmiyorum
	public static final double PI = 3.14;

	public static void getMenu() {
		System.out.println("* * * * * * * * * * ** * * *  * * * *");
		System.out.println("*       Geometrik Hesaplayıcı       *");
		System.out.println("* * * * * * * * * * ** * * *  * * * *");
		System.out.println("1- Kare Alanı Hesaplama");
		System.out.println("2- Kare Çevresi Hesaplama");
		System.out.println("3- Dikdörtgen Alanı Hesaplama");
		System.out.println("4- Dikdörtgen Çevre Hesaplama");
		System.out.println("5- Daire Alanı Hesaplama");
		System.out.println("6- Daire Çevre Hesaplama");
		System.out.println("7- Çıkış");
	}

	public static int kareAlanHesapla() {
		int sonuc = 0;
		System.out.println("Lütfen karenin bir kenarını giriniz.");
		int kenar = sc.nextInt();
		sonuc = kenar * kenar;
		return sonuc;
	}

	public static int kareCevreHesapla() {
		int sonuc = 0;
		System.out.println("Lütfen karenin bir kenarını giriniz.");
		int kenar = sc.nextInt();
		sonuc = 4 * kenar;
		return sonuc;
	}

	public static int dikdortgenAlanHesapla() {
		int sonuc = 0;
		System.out.println("Lütfen dikdörtgenin kısa kenarını giriniz.");
		int kisaKenar = sc.nextInt();
		System.out.println("Lütfen dikdörtgenin uzun kenarını giriniz.");
		int uzunKenar = sc.nextInt();
		sonuc = kisaKenar * uzunKenar;
		return sonuc;
	}

	public static int dikdortgenCevreHesapla() {
		int sonuc = 0;
		System.out.println("Lütfen dikdörtgenin kısa kenarını giriniz.");
		int kisaKenar = sc.nextInt();
		System.out.println("Lütfen dikdörtgenin uzun kenarını giriniz.");
		int uzunKenar = sc.nextInt();
		sonuc = 2 * (kisaKenar + uzunKenar);
		return sonuc;
	}

	public static double daireAlanHesapla() {
		double sonuc = 0;
		System.out.println("Lütfen dairenin yarıçapını giriniz");
		double cap = sc.nextDouble();
		sonuc = PI * cap * cap;
		return sonuc;
	}

	public static double daireCevreHesapla() {
		double sonuc = 0;
		System.out.println("Lütfen dairenin yarıçapını giriniz");
		double cap = sc.nextDouble();
		sonuc = 2 * PI * cap;
		return sonuc;
	}

	public static void geometrikHesaplayıcı() {
		boolean exit = false;
		while (exit == false) {
			getMenu();
			int number = sc.nextInt();
			switch (number) {
			case 1:
				int kareAlan = kareAlanHesapla();
				System.out.println("Karenin Alanı : " + kareAlan + "\n");
				break;
			case 2:
				int kareCevre = kareCevreHesapla();
				System.out.println("Karenin Çevresi : " + kareCevre + "\n");
				break;
			case 3:
				int dikdortgenAlan = dikdortgenAlanHesapla();
				System.out.println("Dikdörtgenin Alanı : " + dikdortgenAlan + "\n");
				break;
			case 4:
				int dikdortgenCevre = dikdortgenCevreHesapla();
				System.out.println("Dikdörtgenin Çevresi : " + dikdortgenCevre + "\n");
				break;
			case 5:
				double daireAlan = daireAlanHesapla();
				System.out.println("Dairenin Alanı : " + daireAlan + "\n");
				break;
			case 6:
				double daireCevre = daireCevreHesapla();
				System.out.println("Dairenin Çevresi : " + daireCevre + "\n");
				break;
			case 7:
				exit = true;
				System.out.println("\n\nİyi günler");
				break;

			default:
				System.out.println("\n\nLütfen aralık içinde bir değer giriniz..!!! (1-7)\n\n");
				break;
			}

		}

	}

	public static void main(String[] args) {
		/*
		 * Geometrik hesaplamalar yapanprogramı yazınız.
		 */
		geometrikHesaplayıcı();

	}

}
