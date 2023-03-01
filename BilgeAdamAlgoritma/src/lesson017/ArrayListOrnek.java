package lesson017;

import java.util.ArrayList;
import java.util.List;

public class ArrayListOrnek {

	//Bir tane array list oluşturalım
	//Arraylist içine manuel şehir atalım.
	//Bu şehirlerden AN ile başlayan varsa bu şehri "xx" ile değiştirelim
	
	public static void main(String[] args) {
		
		List<String> sehirler = new ArrayList<>();
		sehirler.add("Adana");
		sehirler.add("Ankara");
		sehirIsimDegistir(sehirler);
		
	}
	
	public static void sehirIsimDegistir(List<String> sehirler) {
		for (String sehir : sehirler) {
			if(sehir.toLowerCase().startsWith("an")) {
				sehir = "xxx";
			}
			System.out.println(sehir);
		}
	}
}
