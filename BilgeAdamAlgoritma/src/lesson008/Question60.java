package lesson008;

import java.util.Scanner;

public class Question60 {
	
	
	public static  int yasHesapla(int yil) {
		int yas = 2023-yil;
		return yas;
	}
	
	public static int yuzyilHesapla(int yil) {
		
		int yuzYil = yil / 100;
		
		
		return yuzYil+1;
	}
	public static void bilgileriYazdir(int yil) {
		System.out.println("Yaşınız : "+yasHesapla( yil) );
		System.out.println("Kaçıncı Yüzyılda doğdunuz : "+yuzyilHesapla(yil) );
	}
	

	public static void main(String[] args) {

		//Doğum yılınzıı girerek yaşınızı ve
		//Hangi yüzyılda doğduğunuzu hesaplayan metodlar
		//3 farklı metod
		//Yas Hesapla
		//yüzyıl hesapla
		//Bilgileri yazdır.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Doğum yılınızı giriniz");
		int yil = sc.nextInt();
		bilgileriYazdir(yil);

	}

}
