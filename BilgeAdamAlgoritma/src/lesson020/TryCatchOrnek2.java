package lesson020;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchOrnek2 {

	public static void main(String[] args) {
		String[] array = { "6", "10", "bc", null, "20" };

		// elemaniGetir(array);
		elemanlariTopla(array);
		elemanlariTopla2(array);
	}

	private static void elemanlariTopla(String[] array) {
		int toplam = 0;
		int hata = 0;

		for (String s : array) {
			try {
				// toplam = toplam + Integer.parseInt(s);
				toplam = toplam + Integer.valueOf(s);
			} catch (Exception e) {
				hata++;
			}
		}

		System.out.println("Toplam : " + toplam + " Hata : " + hata);

	}

	private static void elemanlariTopla2(String[] array) {
		int toplam = 0;
		int hata = 0;

		for (String s : array) {
			
			try {
				// toplam = toplam + Integer.parseInt(s);
				toplam = toplam + Integer.valueOf(nullCheck(s));
			} catch (Exception e) {
				hata++;
			}
		}

		System.out.println("Toplam : " + toplam + " Hata : " + hata);

	}

	private static void elemaniGetir(String[] array) {
		int index = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Index giriniz");
			index = sc.nextInt();
			System.out.println(array[index]);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(Constant.OUT_OF_INDEX);
		} catch (InputMismatchException e) {
			System.out.println(Constant.MIS_MATCH_EXCEPTION);
		} catch (Exception e) {
			System.out.println(Constant.UNEXPECTED_EXCEPTION);
		}

	}
	
	public static String nullCheck(String s) throws NullPointerCheck {
		if (s == null) {
			throw new NullPointerCheck("aaa");
		}
		return s;
	}
	
	//NullPointerCheck sınıfı oluşturalım.

	/*
	 * Parametre olarak array alan ve girdiğimiz değere karşılık gelen indexi
	 * getiren bir metod yazalım
	 * 
	 * Array içinde gezelim. Sayısal değerleri int e çevirip toplayalım. Döngü
	 * sonunda sayıların toplamını ve toplam hata sayısını yazdıralım.
	 */
}
