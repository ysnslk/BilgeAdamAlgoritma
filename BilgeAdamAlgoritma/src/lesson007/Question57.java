package lesson007;

public class Question57 {

	// Topla metodu yazalım.
	// Toplam sonucunu kontorl edelimi
	// Sayının 10 dan büyük olup olmadığını bulalım

	private static int topla(int sayi1, int sayi2) {

		int toplam = sayi1 + sayi2;
		return toplam;

	}
	private static boolean boolCheck () {
		boolean check;
		if(topla(15,12)>= 18) {
			check = true;
		}
		else {
			check = false;
		}
		return check;
		
	}

	public static void main(String[] args) {

		int toplaSonuc = topla(15,12);
		System.out.println(toplaSonuc);
		if(toplaSonuc > 10) {
			System.out.println("10 dan büyük");
		}
		else {
			System.out.println("10 dan küçük ve ya eşit");
		}
		
		
		System.out.println("*****************");
		System.out.println(boolCheck());
		System.out.println(toplaSonuc >18 ? "Mekana gireblirsin": "Mekana giremezsiz");
		//Yukarıdaki yazım if elsin aynısı !!!!!!!!

	}
}
