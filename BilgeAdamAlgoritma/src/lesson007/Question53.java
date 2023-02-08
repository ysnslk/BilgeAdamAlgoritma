package lesson007;

import java.util.Scanner;

public class Question53 {

	public static void main(String[] args) {
		// İki kez üst üste  aynı sayı klavyeden girilene kadar döngü devam edecek.
		//iki kez üst üste girlidiğinde o zamana kadar girilen sayıların ortalamasını veren 
		Scanner sc = new Scanner(System.in);
		boolean kontrol = true;
		int eskiSayi=0,sayi,toplam = 0,ortalama = 0,sayac = 0;
		
		while (kontrol == true) {
			System.out.println((sayac+1)+". sayıyı giriniz\n");
			sayi = sc.nextInt();
			if(sayi != eskiSayi) {
				toplam = toplam + sayi ;
				eskiSayi = sayi;
				sayac ++;
			}
			else {
				kontrol = false;
			}
		}
		ortalama = toplam / sayac;
		System.out.println("Girilen Sayı : "+ sayac);
		System.out.println("Sayıların Ortalaması : "+ortalama*1f);
	
		

	}

}
