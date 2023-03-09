package lesson022;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiOrnek {

	public static void main(String[] args) {
		List<Integer> sayilar = new ArrayList<>();
		List<Integer> sayilar2 = new ArrayList<>();
		sayilar.add(61);
		sayilar.add(55);
		sayilar.add(78);
		sayilar.add(42);
		sayilar.add(25);
		
		//5 ile bolunen sayıları bir listeye atalım
		
		sayilar.stream().forEach(sayi -> {
			if(sayi %5 == 0) {
				sayilar2.add(sayi);
			}
		});
		
		List<Integer> sayilar3 = sayilar.stream()
				.filter(sayi -> sayi %5 == 0)
				//.toList();
				.collect(Collectors.toList());

		System.out.println(sayilar2);
		System.out.println(sayilar3);
		
		
		//Sayıların kendisi ile çarpıp yeni bir listeye atalım.
		
		List<Integer> map = sayilar.stream().map(sayi -> (sayi * sayi))
				.collect(Collectors.toList());
		map.stream().forEach(sayi -> System.out.println(sayi));
		
		//Kaç tane 5 e bölünen sayı var ?
		System.out.println("5 e Bölünen Sayılar : "+sayilar3.size());
		
		long count = sayilar.stream()
				.filter(sayi -> sayi %5 == 0)
				.count();
				//.collect(Collectors.counting());
		System.out.println(count);
	}

}
