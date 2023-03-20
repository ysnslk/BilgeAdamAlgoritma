package lesson025;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * ogretmen sınıfı thred yapalım
 *	run methodu override edelim 10 kere dönsün
 *	1.ögrencinni notları okundu
 *	2.ogrencinin notları okundu
 *
 *	OgretmenTest sınıfı açalım 2 tane öğretmen nesnesi oluşturup 
 *	2 tane thred oluşturalım
 */
public class Ogretmen extends Thread {
	String name;
	List<Ogrenci> notuOkunanlar = new ArrayList<>();
	BufferedReader bufferedReader;

	public Ogretmen(String name, BufferedReader bufferedReader) {
		super();
		this.name = name;
		this.bufferedReader = bufferedReader;
	}

//	@Override
//	public void run() {
//		for (int i = 0; i < 10; i++) {
//			System.out.println(name +" " + i + ". Ögrencinin notu okundu");
//		}
//	}

//	@Override
//	public void run() {
//		File file = new File("ogrenci.txt");
//
//		try {
//			FileReader fileReader = new FileReader(file);
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			String line;
//			while ((line = bufferedReader.readLine()) != null) {
//				String[] array = line.split(",");
//				double ort = ortalamaHesapla2(Arrays.asList(array));
//				Ogrenci ogrenci = new Ogrenci(array[0], ort);
//				notuOkunanlar.add(ogrenci);
//				System.out.println(name + " Ogretmene--> " + ogrenci.getIsim() + " adlı ögrenci eklendi");
//			}
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//	}
	
	@Override
	public void run() {
		try {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] array = line.split(",");
				double ort = ortalamaHesapla2(Arrays.asList(array));
				Ogrenci ogrenci = new Ogrenci(array[0], ort);
				notuOkunanlar.add(ogrenci);
				System.out.println(name + " Ogretmene--> " + ogrenci.getIsim() + " adlı ögrenci eklendi");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public double ortalamaHesapla2(List<String> list) {
		return list.subList(1, list.size()).stream().collect(Collectors.averagingDouble(x -> Double.parseDouble(x)));
	}
}