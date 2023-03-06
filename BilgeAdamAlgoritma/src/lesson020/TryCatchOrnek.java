package lesson020;

import java.nio.file.spi.FileSystemProvider;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchOrnek {

	/*
	 * Bir tane bölme metodu yazalım Kullanıcıdan 2 sayı alacağız ve bölümü return
	 * edicez bunu yaparken gerekli hatalara karşı önlem alalım
	 * 
	 * 
	 * Kullanıcıdan dogru sonuc girene kadar kullanıcıdan girdi alıcaz
	 * 
	 */

	public static void main(String[] args) {

		double bolum1;
		try {
			bolum1 = bolme();
			System.out.println(bolum1);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.println((e.getMessage()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static double bolme() throws Exception {
		boolean result = true;
		double islem = 0;
		double bolunen = 0;
		double bolen = 0;
		while (result) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Bölmek istediğiniz sayıyı giriniz");
				bolunen = sc.nextDouble();
				System.out.println("Bölen sayıyı giriniz");
				bolen = sc.nextDouble();
				islem = bolunen / bolen;
				result = false;
			} catch (ArithmeticException e) {
				System.out.println(Constant.NUMBER_EQUALS_ZERO);
			} catch (InputMismatchException e) {
				System.out.println(Constant.MIS_MATCH_EXCEPTION);
			} catch (Exception e) {
				System.out.println(Constant.UNEXPECTED_EXCEPTION);
			}
			if (bolen == 0) {
				throw new IllegalArgumentException(Constant.ILLEGAL_ARGUMENT);
			}
		}
		return islem;
	}
}
