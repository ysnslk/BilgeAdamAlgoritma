package lesson007;

public class Question59 {

	public static void main(String[] args) {
		// 2 farklı metod yazalım
		// parametre olarak farklı bir diziye atacak
		// tek elemanları farklı bir diziye atıcak

		// diğer metotta teksayıların olduğu diziyi ekrana yazdıracak

		int[][] matris = { { 56, 23, 678, 231, 5 }, { 234, 21, 78, 26, 6 }, { 654, 33, 32, 67, 2 },
				{ 189, 35, 56, 89, 8 } };

		;
		int[] tekler = tekSayilariAta(matris);
		yazdir(tekler);
 
	}

	public static void yazdir(int[] dizi) {
		for (int i = 0; i < dizi.length; i++) {
			if(dizi[i]!= 0) {
				System.out.print(dizi[i]+ " ");
			}
		}
	}

	public static int[] tekSayilariAta(int[][] dizi) {
		int[] tekSayiler = new int[dizi.length * dizi[0].length];
		int sayac = 0;
		for (int i = 0; i < dizi.length; i++) {
			for (int j = 0; j < dizi[i].length; j++) {
				if (dizi[i][j] % 2 != 0) {
					tekSayiler[sayac] = dizi[i][j];
					sayac++;
				}
			}
		}
		return tekSayiler;
	}

}
