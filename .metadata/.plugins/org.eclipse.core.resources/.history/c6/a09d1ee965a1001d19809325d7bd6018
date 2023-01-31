package lesson002;

import java.util.Scanner;

public class Question16 {
	// Kullanıcıdan aldığımız sayı haftanın hangi güne denk geliyor
	// Bu gün hafta içi mi hafta sonu mu ?

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int sayi;
		boolean hici = true;
		String hafta = hici == true ? "Hafta içi" : "Hafta Sonu";
		System.out.println("Sayı giriniz");
		sayi = sc.nextInt();
		switch (sayi) {
		case 1:
			System.out.println("Pazartesi");
			break;
		case 2:
			System.out.println("Salı");
			break;
		case 3:
			System.out.println("Çarşamba");
			break;
		case 4:
			System.out.println("Perşembe");
			break;
		case 5:
			System.out.println("Cuma");
			break;
		case 6:
			System.out.println("Cumartesi");
			hici = false;
			break;
		case 7:
			System.out.println("Pazar");
			hici = false;

		default:
			System.out.println("Lütfen geçerli bir sayı girin (1-7)...!");
			break;
		}
		System.out.println(hafta);
	}

}
