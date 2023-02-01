package lesson003;

import java.util.Scanner;

public class Question29 {

	public static void main(String[] args) {
		//Kullanıcı sıfıra basana kadar girilen sayıları çarp
		Scanner sc = new Scanner(System.in);
		int sayi,carpim=1;
		do {
			System.out.println("Sayı Giriniz");
			sayi = sc.nextInt();
			if(sayi ==0) {
				break;
			}
			carpim = carpim * sayi;
		} while (sayi!=0);
		System.out.println("Sayıların Çarpımı : "+carpim);
	}

}
