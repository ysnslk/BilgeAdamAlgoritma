package lesson002;

import java.util.Scanner;

public class Question11 {

	public static void main(String[] args) {

		// Dairenin çevresini ve alalını hesaplayn program
		// r değerini kullanıcıdan alalım.
		final float PI = 3.14f;
		float r, cevre, alan;
		Scanner sc = new Scanner(System.in);
		System.out.println("Yarıçap değerini giriniz.");
		r = sc.nextInt();
		if(r<=0) {
			System.out.println("Pozitif Değer Girin...!");
		}
		else {
			alan = PI * r * r;
			cevre = 2 * PI * r;
			System.out.println("Dairenin alanı : " + alan);
			System.out.println("Dairenin çevresi : " + cevre);
		}

	}

}
