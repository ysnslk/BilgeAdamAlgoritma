package com.hw002;

import java.util.Random;
import java.util.Scanner;

public class MainTV {

	static Scanner sc = new Scanner(System.in);

	static Televizyon tv;
	static boolean tvStatus = false;
	static int hak = 3;

	public static void menu() {
		System.out.println("0- Çıkış \n" + "1-- Televizyon Kur\n" + "2-- Televizyonu Aç\n" + "3-- Sesini Artır\n"
				+ "4-- Sesi Azalt\n" + "5-- Kanal Değiştir\n" + "6-- Kanal Bilgisi Goster\n" + "7-- Televizyonu Kapat\n"
				+ "8-- Menüyü Goster\n");
	}

	public static void tvKurveKanallariOlustur() {
		String tvMarka = Util.StringDegerAl("Televizyonunuzun markasını giriniz.");
		String boyut = Util.StringDegerAl("Televizyonunuzun boyutunu giriniz (inch)");
		boyut = boyut + " inch";
		tv = new Televizyon(tvMarka, boyut);
		tv.kanallarıOlustur();
		System.out.println("Kurulum başarı ile tamamlandı");
		System.out.println("Tv Markası : " + tvMarka);
	}

	public static void tvAcKapat() {
		if (tv != null) {

			tvStatus = !tvStatus;

			if (tvStatus) {
				System.out.println("Televizyon Açıldı.");
				Random rnd = new Random();
				int randomKanalID = rnd.nextInt(0, 3);
				tv.setMevcutKanal(tv.getKanallar().get(randomKanalID));
				System.out.println("Şu anki kanal : " + tv.getKanallar().get(randomKanalID).getKanalAdi());
			} else {
				System.out.println("Televizyon Kapandı..!");
			}
		} else {
			hak--;
			System.out.println("İlk Önce Kurulum Yapın...!");
			System.out.println("Kalan Hak : " + hak);
			if (hak == 0) {
				System.out.println(
						"Üzgünüz tüm haklar doldu . Güvenlik için televizyon kapatılıyor. Lütfen televizyonunuzu kapatıp tekrar açın...!");
				System.exit(0);
			}
		}

	}

	public static void main(String[] args) {
		
		menu();
		boolean tvKapat = false;
		while (!tvKapat) {
			System.out.println("Seçiminiz (Menüyü Görmek için 8)");
			Scanner scanner = new Scanner(System.in);
			int secim = scanner.nextInt();

			switch (secim) {
			case 1:
				tvKurveKanallariOlustur();
				break;
			case 2, 7:
				tvAcKapat();
				break;
			case 3:
				tv.sesArttir();
				break;
			case 4:
				tv.sesAzalt();
				break;
			case 5:
				tv.kanalListele();
				int kanalID = Util.intDegerAl("Gitmek istediğiniz kanal numarsını giriniz");
				tv.kanalDegistir(kanalID);
				break;
			case 6:
				tv.kanalBilgiGoster();
				break;
			case 8:
				menu();
				break;
			case 0:
				tvKapat = true;
				System.out.println("Çıkış Yapıldı...!");
				break;

			}
		}

	}

}
