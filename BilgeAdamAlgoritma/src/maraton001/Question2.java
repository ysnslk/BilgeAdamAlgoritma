package maraton001;

public class Question2 {

	public static void tekrarEdeniBul() {
		int[] dizi =   { 7, 7,9, 7, 5, 3, 7, 7, 23, 18, 2, 0, 7 ,22,7, 7,7, 7};
		int tekrar = 0, tekrarEden = 0;
		for (int i = 0; i < dizi.length; i++) {
			for (int j = 0; j < dizi.length; j++) {
				if (i != j) {
					if (dizi[i] == dizi[j]) {
						
						tekrarEden = dizi[i];
						tekrar++;
						break;
					}
				}
			}

		}
		if (tekrar > 0) {
			System.out.println(tekrarEden + " Sayısı dizide " + tekrar + " kere tekrarlanmıştır.");
		} else {
			System.out.println("Tekrar eden sayı bulunamamıştır");
		}
	}

	public static void main(String[] args) {
		
		/*
		 * Bir dizide tekrar eden sayıyı bulan ve ekrana yazdıran bir static metodyazınız.
		 * Metod parametre  olarak int dizisi alacak ve ilk tekrar eden sayıyı bulup ekrana yazdıracaktır.
		 * Tekrareden sayı bulunmazsa “Tekrar eden sayı bulunamamıştır.” yazacaktır.
		 */
		
		
		tekrarEdeniBul();

	}

}
