package lesson008;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Question65 {
	
	public static int[] randomSayiUret() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Lütfen Dizinin boyutunu giriniz.");
		Random rnd = new Random();
		int uzunluk = sc.nextInt();
		int[] array  = new int[uzunluk];
		for (int i = 0; i < array.length; i++) {
			array[i] = rnd.nextInt(1,501);
			System.out.println(array[i]);
		}
		return array;
		
	}

	public static double ortalamaHesapla(int[] array) {
		double toplam = 0,ortalama = 0;
		for (int i = 0; i < array.length; i++) {
			toplam += array[i];
		}
		ortalama = toplam/array.length;
		return ortalama;
	}
	
	public static void main(String[] args) {

		//randomSayıUret metodu yazalım 1 500 
		// Ortalamahesapla

		// Kullanıcıdan kaç tane sayıyla işlem yapmasını istediğini soralım
		// Random sayılar bu arraye atılacak
		// Ortalama hesaplanıcak

		int[] array = randomSayiUret();
		System.out.println(ortalamaHesapla(array));
	}

}
