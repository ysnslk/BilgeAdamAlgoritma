package lesson003;

import java.util.Scanner;

public class Question27 {

	public static void main(String[] args) {
		//Girilen sayının basamaklarının toplamını bulalım
		Scanner sc = new Scanner(System.in);
		System.out.println("Sayı giriniz");
		int sayi = sc.nextInt();
		int toplam=0;
		do {
			toplam = toplam + sayi%10;
			sayi = sayi/10;
			
		}while(sayi>0);
			System.out.println(toplam);

			
		
	}

}
