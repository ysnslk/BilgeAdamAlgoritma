package lesson005;

public class Question42 {

	public static void main(String[] args) {
		int[] sayilar = {2,4,10,5};
		//SAyı tektir çifttir diye çıktı al.
		//Dizi içindeki eleman toplamını yazdır
		int toplam=0;
		for(int i = 0;i<sayilar.length;i++){
			if(sayilar[i]%2==0) {
				System.out.println(sayilar[i]+" Sayısı Çifttir.");
			}
			else{
				System.out.println(sayilar[i]+" Sayısı Tektir.");
			}
			toplam = toplam +sayilar[i];
		}
		System.out.println("Dizi elemanları toplamı : "+toplam);
	}

}
