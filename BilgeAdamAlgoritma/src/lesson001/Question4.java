package lesson001;

import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {
		// Verilen iki sayıdan hangisinin büyük olduğunu gösteren

		int sayi1 = 10, sayi2 = 20;
		Scanner input = new Scanner(System.in);
		if (sayi1 > sayi2) {
			System.out.println("Sayı1 > Sayı2");
		} 
		else if (sayi1 < sayi2) {
			System.out.println("Sayi2 > Sayı1");
		} 
		else {
			System.out.println("Sayı1 = Sayı2");
		}

		// Girilen iki sayıdan hangisinin büyük olduğunu gösteren
		System.out.println("1. sayıyı girin");
		sayi1 = input.nextInt();
		System.out.println("2. sayıyı girin");
		sayi2 = input.nextInt();
		if (sayi1 > sayi2) {
			System.out.println("1. sayı daha büyük");
		} 
		else if (sayi1 < sayi2) {
			System.out.println("2. sayı daha büyük");
		} 
		else {
			System.out.println("Sayılar birbirine eşit");
		}

	}

}
