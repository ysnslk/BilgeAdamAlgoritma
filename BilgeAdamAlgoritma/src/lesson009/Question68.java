package lesson009;

import java.util.Scanner;

public class Question68 {
	public static Scanner sc = new Scanner(System.in);
	public static int sesliHarfBul(String kelime) {
		int sayac = 0;
		char[] sesliHarfler = { 'a', 'e', 'i', 'o', 'u' };
		for (int j = 0; j < sesliHarfler.length; j++) {
			for (int i = 0; i < kelime.length(); i++) {
				if ( kelime.charAt(i)==sesliHarfler[j] ) {
					sayac++;
				}
			}

		}
		return sayac;
	}

	public static void main(String[] args) {
		// girilen kelimedeki sesli harflerin sayısını bulan metodu yazınız.
		// Metod int dönsün parametre string
		System.out.println("Kelimeyi giriniz");
		String a = sc.nextLine();
		System.out.println(sesliHarfBul(a));
	}

}
