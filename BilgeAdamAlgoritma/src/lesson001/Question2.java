package lesson001;

import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		// Verilen iki sayının çarpımını veren program
		int n1 = 10;
		int n2 = 10;
		int x = 0;
		x = n1 * n2;
		System.out.println("Çarpım : " + x);

		// Girilen 2 sayının çarpımı

		System.out.println("**************************");
		Scanner input = new Scanner(System.in);
		System.out.println("Sayı girin");
		n1 = input.nextInt();
		System.out.println("Sayı girin");
		n2 = input.nextInt();
		x = n1 * n2;
		System.out.println("Çarpım :"+x);

	}

}
