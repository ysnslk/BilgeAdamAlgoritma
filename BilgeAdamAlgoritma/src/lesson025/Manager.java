package lesson025;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Manager {
	File file = new File("ogrenci.txt");
	List<Ogrenci> ogrenciler = new ArrayList<>();

	public void dosyadanVeriOku() {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String okunan = null;
			while ((okunan = reader.readLine()) != null) {
				Ogrenci ogrenci = new Ogrenci(okunan.split(",")[0]);
				ogrenciler.add(ogrenci);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		ogrenciler.forEach(System.out::println);
	}

	public void dosyadanVeriOku2() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String isim = "";
			while ((isim = bufferedReader.readLine()) != null) {
				String[] array = isim.split(","); // {Mustafa,87,76,60,}
				double ort = ortalamaHesapla2(Arrays.asList(array));

				Ogrenci ogrenci = new Ogrenci(array[0], ort);
				ogrenciler.add(ogrenci);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ogrenciler.forEach(System.out::println);
	}

	// [Mustafa,80,76,60]
	public double ortalamaHesapla(List<String> list) {
		double toplam = 0;
		for (int i = 1; i < list.size(); i++) {
			toplam = toplam + Double.parseDouble(list.get(i));
		}
		return toplam / (list.size() - 1);
	}

	// [Mustafa,80,76,60]
	// [80,76,60]
	public double ortalamaHesapla2(List<String> list) {
		return list.subList(1, list.size()).stream().collect(Collectors.averagingDouble(x -> Double.parseDouble(x)));
	}

	// String olarak yazıyo 1milyon veri
	// object--> byte -->
	public void dosyayaOgrenciYaz() {
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("ogrenciIsleri.txt"))) {
			ogrenciler.forEach(x -> {
				try {
					writer.writeObject(x);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void dosyayaOgrenciYaz2() {
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("ogrenciIsleri2.txt"))) {
			writer.writeObject(ogrenciler);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deserilize() {

		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("ogrenciIsleri.txt"))) {
			Ogrenci ogrenci;
			while ((ogrenci = (Ogrenci) reader.readObject()) != null) {
				System.out.println("---> " + ogrenci);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deserilize2() {
		try {
			ObjectInputStream reader = new ObjectInputStream(new FileInputStream("ogrenciIsleri2.txt"));
			List<Ogrenci> ogrenciListesi= (List<Ogrenci>) reader.readObject();
			ogrenciListesi.forEach(System.out::println);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}