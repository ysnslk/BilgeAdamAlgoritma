package lesson005;

import java.util.Iterator;
import java.util.Scanner;

public class HW {

	public static void main(String[] args) {

		// 1
		// Question 43 için ÖDEV--> kaçları saymak istiyosak kullanıcıdan sayıları
		// alalım.

		int[] array = { 1, 3, 4, 4, 4, 4, 2, 2, 9, 8, 8 };
		int sayac = 0, hangiSayi;
		System.out.println("Bir sayı girin.");
		Scanner sc = new Scanner(System.in);
		hangiSayi = sc.nextInt();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == hangiSayi) {
				sayac++;
			}
		}
		System.out.println(hangiSayi + " sayısı dizide " + sayac + " kere tekrarlanıyor.");

		// 2
		// Bir dizide en büyük ikinci sayıyı bulan program
		int yedek = 0;
		int nums[] = { 1, 13, 13, 13, 2, 5, 13, 1 };
		int siraliDizi[] = new int[nums.length];
		for (int i = 0; i < siraliDizi.length; i++) {
			for (int j = i + 1; j < siraliDizi.length; j++) {
				yedek = nums[i];
				nums[i] = siraliDizi[j];
				siraliDizi[j] = yedek;
			}

		}
		System.out.println("Dizinin en büyük ikinci elemanı : " + siraliDizi[siraliDizi.length - 1]);

		// 3
		// bir dizide eğer 13 var ise hem 13ü hemde bir sonraki indexi
		// toplama işlemine almicak
		// dizideki elemanların toplamını bulalım
		int nums2[] = { 1, 13, 5, 13,13, 2, 5, 7, 1 ,13 };
		// 1 + 5 + 7 +1
		// toplam --> 1 + 5 = 6
		int toplam = 0;
		for (int i = 1; i < nums2.length; i++) {

			if (nums2[i] == 13) {
				continue;
			}
			else if(nums2[i-1] == 13) {
				continue;
			}
			toplam = toplam + nums2[i];
		}
		if(nums2[0] !=13)
		{
			toplam = toplam + nums2[0];
		}

		System.out.println("Dizinin toplamı : " + toplam);

	}
}
