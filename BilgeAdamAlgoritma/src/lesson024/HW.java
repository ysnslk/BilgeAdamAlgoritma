package lesson024;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class HW {
	// Toplam Satır Sayısı-->50
	// Toplam Kelime Sayısı--> 273
	// toplam Karakter Sayısı--> 1593
	// En çok tekrar eden kelime--> akrdaş

	static String path = "mars.txt";
	static String[] kelime = null;
	static HashMap<String , Integer> mMap = new HashMap<>();

	public static void main(String[] args) {
		bigiler(path);
		tekrarEden(path);
	}

	public static void bigiler(String file) {
		int satirSayisi = 0;
		int kelimeSayisi = 0;
		int karakterSayisi = 0;
		try (Scanner sc = new Scanner(new BufferedReader(new FileReader(file)))) {

			while (sc.hasNextLine()) {
				satirSayisi++;
				String okunanSatir = sc.nextLine();
				kelime = okunanSatir.split(" ");
				kelimeSayisi += kelime.length;
				for (int i = 0; i < kelime.length; i++) {
					karakterSayisi = karakterSayisi + kelime.length;
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("Dosya bulunamadı");
			e.printStackTrace();
		}
		System.out.println("Satır Sayisi : " + satirSayisi);
		System.out.println("Kelime Sayısı : " + kelimeSayisi);
		System.out.println("Karakter Sayısı : " + karakterSayisi);

	}

	public static void tekrarEden(String file) {
		try (Scanner sc = new Scanner(new BufferedReader(new FileReader(file)))) {
			int tekrarSay = 0;
			String tekrarEden = "";
			while (sc.hasNext()) {
				String okunanSatir = sc.nextLine();

				kelime = okunanSatir.split(" ");
				for (String k : kelime) {
					if(mMap.containsKey(k)) {
						mMap.put(k, mMap.get(k)+1);
					}
					else {
						mMap.put(k,+1);
					}
				}

			}
			for (String k : mMap.keySet()) {
				if(!k.equalsIgnoreCase("") && mMap.get(k) >= tekrarSay) {
					tekrarSay = mMap.get(k);
					tekrarEden = k;
				}
			}
			System.out.println("En çok Tekrar Eden : "+ tekrarEden +" Tekrar Sayısı : "+ tekrarSay);
		} catch (FileNotFoundException e) {
			System.out.println("Dosya bulunamadı");
			e.printStackTrace();
		}
	}

}