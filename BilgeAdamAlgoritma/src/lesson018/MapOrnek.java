package lesson018;

import java.util.HashMap;
import java.util.Scanner;

public class MapOrnek {

	public static void main(String[] args) {
		/*
		 * Character ve int tutan bir map oluşturalım
		 * Kullanıcıdan bir kelime alalım
		 * Kelimede hangi harften kaç tane var onu yazalım
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Bir kelime girin");
		String kelime = sc.nextLine();
		HashMap<Character , Integer> karakter = new HashMap<>();
		for (int i = 0; i < kelime.length(); i++) {
			char c = kelime.charAt(i);
			if(karakter.containsKey(c)) {
				karakter.put(c, karakter.get(c)+1);
			}
			else {
				karakter.put(c, 1);
			}
		}
		System.out.println(karakter);

	}

}
