package lesson003;

import java.util.Scanner;

public class Question21 {

	public static void main(String[] args) {
		// Girilen sayıya kadar olan sayıların toplamı
		Scanner sc = new Scanner(System.in);
		int sayi, toplam = 0;
		System.out.println("Bir sayı giriniz");
		sayi = sc.nextInt();
		for (int i = 0; i < sayi; i++) {
			toplam = toplam + i;
		}
		System.out.println(toplam);
	}

}
