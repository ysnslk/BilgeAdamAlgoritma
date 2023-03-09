package lesson022.StreamUygulama;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Market {

	EUrun[] product = EUrun.values();
	List<Urun> urunler = new ArrayList<>();
	Map<String, Double> urunMap = new HashMap<>();
	Map<String, Integer> sepetMap = new HashMap<>();

	public Market() {
		urunOlustur();
		urunFiyatMapOlustur();
	}

	public void urunOlustur() {
		// product arrayini liste(internetten araştırın) çevircez daha sonra streame
		// çevircez
		// sonra içinde işlem apabilcek duruma gelcez
		// Urun nesnesi oluşturuken değerleri EURUN içinden alcaz.

		urunler = Arrays.asList(product) // Liste
				.stream()// Stream
				.map(urun -> new Urun(urun.name(), urun.fiyat)).collect(Collectors.toList());
	}

	public void urunleriListele() {
		// urunler.forEach(Urun::toString);
		// urunler.forEach(System.out::println);
		urunler.forEach(urun -> System.out.println(urun.getName()));
	}

	// urunFiyat listesi olustur
	public void urunFiyatMapOlustur() {

		urunMap = urunler.stream().collect(Collectors.toMap(urun -> urun.getName(), urun -> urun.getPrice()));

//		for (Urun urun : urunler) {
//			urunMap.put(urun.getName(), urun.getPrice());
//		}
	}

	public void fiyatListesi() {
		urunMap.forEach((key, value) -> System.out.println(key + "-->  " + value));
		// urunMap.entrySet().forEach(System.out::println);
	}

	// fiyati50 den büyük olan ürünleri Listeleleyelim
	public void fiyati50denBuyukOlanlar() {
		List<String> urunler = urunMap.entrySet().stream().filter(entry -> entry.getValue() > 50).map(Entry::getKey)
				.collect(Collectors.toList());
		System.out.println(urunler);
	}

	// Fiyatı 50 den büyük olan ürünlerin fiyatlarının ortalamasını bulalım
	public void ortalama() {
		// Liste içindeki sayıların ortalamasını nasıl bulurum Stream api ile
		List<Urun> ellidenBuyukler = urunler.stream().filter(x -> x.getPrice() > 50).collect(Collectors.toList());
		double result = ellidenBuyukler.stream().collect(Collectors.averagingDouble(Urun::getPrice));
		System.out.println(result);
//		ellidenBuyukler.stream()
//		.mapToDouble(i -> i.getPrice())
//		.average()
//		.ifPresent(avg -> System.out.println(" Ortalama : "+avg));
	}

	public void SepeteUrunEkle() {

		// Markette var mı yok mu ?
		// Yoksa ürün yok
		// Varsa sepete ekle
		Scanner sc = new Scanner(System.in);
		System.out.println("Eklemek istediğiniz ürünü seçin");
		String urun = sc.nextLine();
		if (urunMap.containsKey(urun)) {
			if (sepetMap.containsKey(urun)) {
				sepetMap.put(urun, sepetMap.get(urun) + 1);
			} else {
				sepetMap.put(urun, 1);
				System.out.println("Ürün sepete eklendi...");
			}
		} else {
			System.out.println("Ürün Listede yok");
		}

	}
	
	public void sepetiGoster() {
		sepetMap.forEach((key,value) -> System.out.println(key+" -> "+ value));
	}

}

//Sepet diye bi class oluşturalım
//product, arreyde tutalım enum arrayi olacak, değerleri EUrun sınıfından alıcak (product) 
//yine aynı şekilde urunler diye bir listemiz olsun enum arrayinden buraya urunleri taşicaz (urunler)
//map olarak sepeti tutcaz burda ürün ismi ve adet alacak şekilde. (sepetMap)

//yine urunleri hem ismini hemde fiyatlarını tutmak için bir map daha oluşturalım. (urunMap)