package lesson018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class MapOrnek2 {

	public static void main(String[] args) {
		String[] ogrenci = { "Ayşe ", "Ece ", "Mahmut " };
		int[] notlar = { 60, 80, 70 };

		HashMap<String, Integer> hp = new HashMap<>();
		for (int i = 0; i < ogrenci.length; i++) {
			hp.put(ogrenci[i], notlar[i]);
		}
		System.out.println(hp);

		// 2

		int[][] notlar2 = { { 50, 50, 60 }, { 80, 90, 70 }, { 25, 75, 80 } };

		HashMap<String, int[]> hp2 = new HashMap<>();
		for (int i = 0; i < ogrenci.length; i++) {
			hp2.put(ogrenci[i], notlar2[i]);
		}

		for (Entry<String, int[]> entry : hp2.entrySet()) {
			System.out.println(entry.getKey());
			for (int i = 0; i < entry.getValue().length; i++) {
				System.out.println(entry.getValue()[i] + " ");
			}
		}
		int[][] notlar3 = { { 50, 50, 60 }, { 80, 90, 70 }, { 25, 75, 80 } };
		HashMap<String, List<Integer>> hp3 = new HashMap<>();
		for (int i = 0; i < notlar3.length; i++) {
			int sira = 1;
			List<Integer> listNotlar = new ArrayList<>();
			for (int j = 0; j < notlar3[i].length; j++) {
				listNotlar.add(notlar3[i][j]);
			}
			hp3.put(ogrenci[i], listNotlar);
		}
		System.out.println(hp3);

		for (Entry<String, List<Integer>> entry : hp3.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());

		}
	}

}
