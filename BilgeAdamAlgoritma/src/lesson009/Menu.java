package lesson009;

import java.util.Scanner;

public class Menu {
	public static Scanner sc = new Scanner(System.in);
	public static void menu() {
		boolean check = true;
		while (check) {
			System.out.println("1- Toplama");
			System.out.println("2- Çıkarma");
			System.out.println("3- Bölme");
			System.out.println("4- Üs Alma");
			System.out.println("0- Çıkış");
			System.out.println("Seçiminiz");
			int secim = sc.nextInt();
			switch (secim) {
			case 1:
				System.out.println("Toplama Sonucu : "+toplama());
				break;
			case 2:
				cikarma();
				break;
			case 3:
				bolme();
				break;
			case 4:
				usAlma();
				break;
			case 0:
				System.out.println("İyi günler");
				check = false;
				break;
			default:
				System.out.println("Geçerli Sayı Giriniz");
				break;
			}
		}
	}

	private static void usAlma() {
		int usSonuc=1;
		System.out.println("Hangi sayının kuvvetini almak istersiniz?");
		int sayi = sc.nextInt();
		System.out.println("Hangi  kuvvetini almak istersiniz?");
		int kuuvet = sc.nextInt();
		for (int i = 0; i < kuuvet; i++) {
			usSonuc *=sayi;
		}
		System.out.println(usSonuc);
		
	}

	private static void bolme() {
		System.out.println("Kaç adet sayı girmek istiyorsunuz");
		int secim = sc.nextInt();
		double sonuc = 0;
		for (int i = 0; i <secim; i++) {
			System.out.println((i+1)+". Sayıyı giriniz : ");
			double sayi = sc.nextInt();
			if(i==0) {
				sonuc+=sayi;
				continue;
			}
			sonuc /= sayi;
		}
		System.out.println("Sonuç : " + sonuc);
		
	}

	private static void cikarma() {
		System.out.println("Kaç adet sayı girmek istiyorsunuz");
		int kacSayi = sc.nextInt();
		int sonuc = 0;
		for (int i = 0; i < kacSayi; i++) {
			System.out.println((i + 1) + ". sayıyı giriniz : ");
			int sayi = sc.nextInt();
			if(i==0) {
				sonuc+=sayi;
				continue;
			}
			sonuc -= sayi;

		}
		System.out.println("Sonuç : " + sonuc);
	}

	public static int toplama() {
		int toplam = 0;
		int i = 1;
		boolean check = true;
		while (check) {
			System.out.println(i + ". Sayıyı giriniz");
			int sayi = sc.nextInt();
			
			if (sayi != 0) {
				toplam += sayi;
				
			}
			else {
				check = false;
			}
			i++;

		}

		return toplam;
	}

}
