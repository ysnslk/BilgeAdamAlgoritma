package lesson008;

public class Question61 {
	
	public static void asalMi(int sayi) {
		boolean asalMi = true;
		for (int i = 2; i < sayi; i++) {
			if(sayi % i == 0) {
				asalMi = false;
			}
		}
		if(asalMi) {
			System.out.println(sayi+" asaldır");
		}
	}

	public static void main(String[] args) {

		//1 den 100 e kadar olan sayıların asal olanlarını bulan metodu yazın.
		// asalMi metodu yazıcaz ,sadece sayılar asal mı diye bakıyoruz.
		// Daha sonra mainde for döngüsüne sokup bakıcaz

		for (int i = 2 ; i < 1000; i++) {
			asalMi(i);
		}
	}

}
