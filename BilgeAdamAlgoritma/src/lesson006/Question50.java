package lesson006;

public class Question50 {

	public static void main(String[] args) {
		// Bir dizide ard arda gelen 2 indexdeki sayı değer
		//2 ise tru yoksa false yazdıaralım.
		boolean check = false;
		int[] sayilar = { 2, -256, -256, 2, 2, 1258, 32 };
		for (int i = 1; i < sayilar.length; i++) {
			check=false;
			if (sayilar[i] == 2 && sayilar[i-1] == 2){
				check=true;
			}
			System.out.println("Kontrol : "+check);
		}
	}

}
