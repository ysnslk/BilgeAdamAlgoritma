package lesson009;

import java.util.Scanner;

public class Question67 {
	public static Scanner sc = new Scanner(System.in);

	public static int buyukleriSay(int[] array, int deger) {
		int sonuc = 0;

		if (array.length > 100 && array.length < 1) {
			System.err.println("Lütfen Array uzunluğunu (1-100 ) Arası Gİrin...!");
		} else {
			for (int j = 0; j < array.length; j++) {
				if (array[j] < 1 && array[j] > 100) {
					System.err.println("Lütfen Dizideki sayıları (1-100) Arası olduğundan emin olun .!! " + array[j]);
					break;
				}

			}
			for (int i = 0; i < array.length; i++) {
				if (deger > array[i]) {
					sonuc++;
				}
			}
		}

		return sonuc;

	}

	public static void main(String[] args) {
		// girilen sayı arraydeki kaç sayıdan büyüj olduğunu bulan metod
		// array uzunluğu 1 ile 100 arasında olacak
		// girilen sayı 1 ile 100 arasında olacak
		// array içindeki sayılar 1 ile 100 arasında olacak
		// metod int dönecek
		int[] myNum = { 1, 3, 4, 6, 9 };
		// buyukleriSay(myNum,6); => 3
		System.out.println("Lütfen bakmak istediğiniz sayıyı girin.");
		int sayi = sc.nextInt();
		if (sayi > 100 && sayi < 1) {
			System.err.println("Girdiğiniz sayı (1-100) Arasında değil");
		} else {
			System.out.println(buyukleriSay(myNum, sayi));
		}

	}

}
