package lesson007;

import java.util.Scanner;

public class Question58 {

	public static void main(String[] args) {
		//Parametre olarak int alan ve int döndüren
		//Girilen sayının kaç basamaklı olduğunu bulan metodu yazın
		
		
		//Daha sonra farklı bi metod yazalım 
		//Sayının 1000den büyük olup olmadığını kontrol edelim.
		Scanner sc = new Scanner(System.in);
		System.out.println("Bir sayı girin");
		int sayi = sc.nextInt();
		int basamak = kacBasamakli(sayi);
		System.out.println(basamak);
		bindenBuyukMu(basamak);
		

	}
	
	private static int kacBasamakli(int x) {
		String sayi = String.valueOf(x);
		int basamak = sayi.length();
		return basamak;
	}
	
	private static void bindenBuyukMu(int x) {
		if(x>=4) {
			System.out.println("1000den büyük veya eşit");
					
		}
		else {
			System.out.println("1000den küçük");
		}
	}

}
