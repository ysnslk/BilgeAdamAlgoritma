package lesson020;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Util {
	static Scanner sc = new Scanner(System.in);

	public static int intDegerAl(String sorgu) {
		System.out.println(sorgu);
		boolean kontrol = false;
		int intDeger = 0;
		do {
			try {
				intDeger = Integer.parseInt(sc.nextLine());
				kontrol = false;
			} catch (Exception e) {
				System.out.println("Lütfen bir rakam değeri giriniz.");
			}
		} while (kontrol);
		return intDeger;
	}

	public static String StringDegerAl(String sorgu) {
		System.out.println(sorgu);
		String StringDeger = sc.next();
		return StringDeger;
	}

	public static LocalDate tarihAl(String sorgu) {
		LocalDate localDate = null;
		System.out.println(sorgu);
		boolean kontrol = false;
		do {
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				localDate = LocalDate.parse(sc.nextLine(), formatter);

				kontrol = false;
			} catch (DateTimeException e) {
				System.out.println(e);
				System.out.println("Lütfen Düzgün Format Giriniz : ( Yıl Ay Gün)");
			}
		} while (kontrol);
		return localDate;
	}

	// Kullanıcıdan String olarak tarih alacağız .(yıl-ay-gün)
	// Aldığımız değeri local date e çevireceğiz.
	// Yanlış formatta yazarsa hata fırlat.

}
