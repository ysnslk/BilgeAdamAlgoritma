package lesson013;

public class Main {

	public static void main(String[] args) {
	
		//Sınav sınıfı oluşturup.//Attirbutleri yazalım.
//		Sinav sinav = new Sinav();
//		Soru s1 = new Soru();
//		s1.soruOlustur(sinav.getCevapSecenekleri());
//		for (int i = 0; i < s1.getCevapIcerikleri().length; i++) {
//			System.out.println(s1.getCevapIcerikleri()[i]);
//		}
//		
		Sinav sinav = new Sinav();
		sinav.sinavOlustur();
		sinav.cevapGir();
		sinav.cevaplariKontrolEt();
//		for (int i = 0; i < sinav.getSorular().length; i++) {
//			System.out.println(sinav.getSorular()[i].getIcerik());
//		}
//		
//		
//		System.out.println("*************************");
//		
	}

}
