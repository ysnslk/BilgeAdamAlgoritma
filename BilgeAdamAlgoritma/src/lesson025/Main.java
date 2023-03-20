package lesson025;

public class Main {
	
	/*
	 * 1-Ögrenci sınıfımız oluşturalım fieldları isim ve ortalama olsun
	 * İlk başta öğrenci oluşturuken sadece isimlerle oluşturalım
	 * 
	 * 2-Ortalama hesapa
	 * 
	 * 3-okunan verileri serilize edip farklı bir dosyaya yazalım
	 */
	
	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.dosyadanVeriOku2();
		manager.dosyayaOgrenciYaz2();
		manager.deserilize2();
		
	}
}