package lesson001;

import java.util.Scanner;

public class Question8 {
	public static void main(String[] args) {
		// Kenarları girilen üçgenin nasıl bir üçgen olduğunu hesaplayan program

		int k1, k2, k3;
		Scanner input = new Scanner(System.in);
		System.out.println("1. Kenarı Girin");
		k1 = input.nextInt();
		System.out.println("2. Kenarı Girin");
		k2 = input.nextInt();
		System.out.println("3. Kenarı Girin");
		k3 = input.nextInt();
		if (k1 == k2 && k2 == k3) {
			System.out.println("Eşkenar Üçgen");
		} 
		else if (k1 == k2 || k2 == k3 || k1 == k3) {
			System.out.println("İkizkenar Üçgen");
		} 
		else {
			System.out.println("Çeşitkenar Üçgen");
		}

	}
}
