package maraton001;

public class Question3 {
	public static int karakterSayici(String cumle, char harf) {
		int sayac = 0;
		for (int i = 0; i < cumle.length(); i++) {
			if (cumle.charAt(i) == harf) {
				sayac++;
			}
		}

		return sayac;
	}

	public static void main(String[] args) {
		/*
		 * karakterSayici isimli staticbir Java metodu yazınız. Bu metod bir String bir
		 * de char değişkenini parametre olarak alacaktır. Fonksiyon paramtre olarak
		 * gelen String içindeki yine parametre olarak gelen karakterin sayısını sayıp
		 * return edecektir.
		 */
		int sonuc = karakterSayici("Bir gün bir gün bir çocuk günlerce evde geceyi geçirmek için", 'g');
		System.out.println(sonuc);
	}

}
