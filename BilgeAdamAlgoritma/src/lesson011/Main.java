package lesson011;

public class Main {
	public static void main(String[] args) {
		// Product sınıfı oluşturalım.
		// Id price name stock
		// bilgileriGoster()
		// değişkenler private
		// Boş constructor

		// Veritabanına kaydedildi
		// Urunu güncelle ->> İsmini güncelle
		
		
		//Sepet sınıf
		//products,totalprice
		
		//Spete ürün ekle metodu 
		//void parametre 
		//Gelen product'ı arrayin içine atalım

		Product p1 = new Product();
		p1.setName("Asus");
		p1.setPrice(100);
		p1.setStock(2);
		p1.bilgilerGoster();

		Product p2 = new Product(2500, "HP", 20);
		p2.bilgilerGoster();
		System.out.println(p2.veritabanınaKaydet());
		p1.ismiGuncelle("Casper");
		System.out.println(p1.getName());
		p1.bilgilerGoster();
		Product p3 = new Product();
		p3.setName("Asus");
		Sepet sepet1 = new Sepet();
		System.out.println(p1.getStock());
		System.out.println(sepet1.getTotalPrice());
		sepet1.sepeteEkle(p2);
		sepet1.sepeteEkle(p2);
		sepet1.sepeteEkle(p3);
		sepet1.sepeteEkle(p2);
		sepet1.sepeteEkle(p1);
		sepet1.sepeteEkle(p2);
		sepet1.sepeteEkle(p1);
//		sepet1.sepeteEkle(p2);
//		sepet1.sepeteEkle(p1);
//		sepet1.sepeteEkle(p2);
//		sepet1.sepeteEkle(p2);
//		sepet1.sepeteEkle(p2);
		System.out.println(sepet1.getIndex());
		System.out.println(p1.getStock());
		System.out.println(sepet1.getTotalPrice());
		
		
		p3.gosterimdenKaldir(p3);
		System.out.println(p3.isActive());
		
		sepet1.getProductsManual();
	}

}
