package lesson017;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ArrayListOrnek2 {

	public static void main(String[] args) {
		// 1 tane çift sayılar
		// 1 tane tek sayılar arraylisti açalım
		// 1 den 100 e kadar 35 tane random sayi üretelim
		// tek çift ayıralım
		ArrayList<Integer> tekArray = new ArrayList<Integer>();
		ArrayList<Integer> ciftArray = new ArrayList<Integer>();
		Random rnd = new Random();
		for (int i = 0; i < 35; i++) {
			int random = rnd.nextInt(1, 101);
			if (random % 2 == 0) {
				tekArray.add(random);
			} else {
				ciftArray.add(random);
			}
		}
		for (int tekSayi : tekArray) {
			System.out.print(tekSayi + " ");
		}
		System.out.println();
		for (int ciftSayi : ciftArray) {
			System.out.print(ciftSayi + " ");
		}

	}

}
