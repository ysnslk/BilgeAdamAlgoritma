package lesson007;

import java.util.Scanner;

public class Question56 {
	
	private static void AdSoyadGetir() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Adınız : ");
		String ad = sc.nextLine();
		System.out.println("Soyadınız : ");
		String soyad = sc.nextLine();
		System.out.println(ad+" "+soyad);
		
	}
private static String AdSoyadGetir(String ad ,String soyad) {
		
		return  ad +" "+ soyad;
		
	}

	public static void main(String[] args) {
		// parametre olarak girilen isim ve soyismi alıp ekrana yazdıralım
		AdSoyadGetir();

		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Adınız : ");
		String ad = sc.nextLine();
		System.out.println("Soyadınız : ");
		String soyad = sc.nextLine();
		System.out.println(AdSoyadGetir(ad,soyad));
		
		
		//AccesModifier
		//private --> Sadece bulunduğu class içinden erişilir.
		//public  --> Bütün proje içinden erişebiliriz.
		//protected-> Aynı package , inherit alan classlar erişebilir.
	}

}
