package lesson009;

import java.util.Scanner;

public class Question66 {
	//Hem class özelliğin oluyor.
	//Hesapte static fieldlar program başladığında kendine özel yer ayırır.
	//Kapanana kadar bellekte yer alır.
	
	
	
	/*
	 * Menuyu oluşturalım Toplama metodu kullanıcı 0 girene kadar sayıları alınız 0
	 * girince sonucu gösterip tekrar menuye dön
	 * 
	 * Çıkarma Kullanıcıdan ilk başta kaç adet sayı girileceğini alalım sonucu
	 * yazdır
	 * 
	 * Bölme
	 * Kullanıcdan kaç adet sayı gireceğini alalım
	 * girlien sayı 1 olduğunda hepsi birbirine bölünecek
	 */

	// int , Integer (wrapper sınıf) farkı,
	// Integer primitive int e hizmet eden bir sınıf
	// int --> null alamaz default 0 olur

	
	public static void main(String[] args) {
		Menu.menu();
	}

}
