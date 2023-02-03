package lesson005;

import java.util.Random;
import java.util.Scanner;

public class Question39 {
	// Sayı tahmin uygulaması
	// Sürekli sayı isteyeceğiz
	// tahmin < sayi TAhmini yükselt
	// tahmin >sayi tahmini azalt
	// Kaçıncı denemede tahmin etti
	public static void main(String[] args) {
		// random integer sayı üretme
		// randoms sayı üretelim 0 ile 100 arasında
		Random rnd = new Random();
		Scanner sc = new Scanner(System.in);
		int randomNumber = rnd.nextInt(0, 101);
		int sayac = 0;
		// int rasgele = (int)(Math.random()*100);
		boolean kontrol = false;
		while (true) {
			sayac++;
			System.out.println("Bir sayı giriniz.");
			int tahmin = sc.nextInt();
			if (tahmin < randomNumber) {
				System.out.println("Sayıyı yükseltin");
			} 
			else if (tahmin > randomNumber) {
				System.out.println("Sayıyı azaltın");
			} 
			else {
				System.out.println("Tahmininiz Doğru");
				System.out.println("Sayıyı "+sayac+ ". denemede buldunuz.");
				
			}

		}
		
	}

}
