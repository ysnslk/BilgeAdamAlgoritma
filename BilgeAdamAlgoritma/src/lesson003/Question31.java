package lesson003;

import java.util.Scanner;

public class Question31 {

	public static void main(String[] args) {
		// Girilen basamakta hangi basamakta hangi sayı var
		Scanner sc = new Scanner(System.in);
		System.out.println("Sayı Girin");
		int sayi = sc.nextInt();
		int i = 1;
;		while(sayi>0) {
			System.out.println(i+"ler basamağı"+sayi%10);
			sayi = sayi/10;
			i=i*10;
		}
	}

}
