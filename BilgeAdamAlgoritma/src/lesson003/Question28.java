package lesson003;

import java.util.Scanner;

public class Question28 {

	public static void main(String[] args) {
		// Girilen sayı 5'in katı mi ?
		Scanner sc = new Scanner(System.in);

		int sayi = sc.nextInt();
		for (int i = 1; i <= sayi; i++) {
			if (sayi % 5 == 0) {
				System.out.println("Sayı 5in katıdır.");
				break;
			} else {
				System.out.println("Sayı 5in katı değildir.");
				break;
			}
		}

		// Girilen sayı 5'in kuvveti mi ?
		int sayi2 = sc.nextInt();
		boolean kontrol = true;
		if (sayi == 0) {
			System.err.println("Sıfırdan farklı bir değer girin.");
		} else {
			while (kontrol == true) {
				if (sayi2 % 5 == 0) {
					sayi2 = sayi2 / 5;
					if (sayi2 == 1) {
						System.out.println("5in kuvvetidir");
						kontrol = false;
					}
				} else {
					System.out.println("5'in kuvveti değildir.");
					kontrol = false;
				}
			}
		}

	}

}
