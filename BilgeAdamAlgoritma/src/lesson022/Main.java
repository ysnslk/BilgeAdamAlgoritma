package lesson022;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kisi k1 = new Kisi("Ahmet", 51, ECinsiyet.ERKEK);
		Kisi k2 = new Kisi("Ali", 34, ECinsiyet.ERKEK);
		Kisi k3 = new Kisi("Zeynep", 45, ECinsiyet.KADIN);
		Kisi k4 = new Kisi("Defne", 24, ECinsiyet.KADIN);
		Kisi k5 = new Kisi("Aslı", 36, ECinsiyet.KADIN);

		List<Kisi> kisiler = new ArrayList<>();
		kisiler.add(k1);
		kisiler.add(k2);
		kisiler.add(k3);
		kisiler.add(k4);
		kisiler.add(k5);
		
		//Kadın olanları farklı bir listeye atalım
		System.out.println("Kadınlar");
		
		List<Kisi> kadinlar = kisiler.stream().filter(kisi -> kisi.getCinsiyet().equals(ECinsiyet.KADIN)).toList();

		System.out.println(kadinlar);
		
		List<Kisi> siralama = kisiler.stream()
				.sorted(Comparator.comparing(Kisi::getAge)).collect(Collectors.toList());
	
		System.out.println(siralama);
	}

}
