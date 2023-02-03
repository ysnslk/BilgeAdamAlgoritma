package lesson005;

public class Question41 {

	public static void main(String[] args) {
		// 0 dan küçük sayılar yerine 0 koyalım.
		int[] sayilar = { 0, 120, -5, -85, -256, 16, 1258, 81, 14 };

		for(int i=0;i<sayilar.length;i++) {
			if(sayilar[i]< 0) {
				sayilar[i]= 100;
				int yeniSayi = sayilar[i];
				System.out.println(i+".index değişti"+yeniSayi);
				
			}
			
		}
		for(int i=0;i<sayilar.length;i++) {
			System.out.println(sayilar[i]);
		}
		
		
	}

}
