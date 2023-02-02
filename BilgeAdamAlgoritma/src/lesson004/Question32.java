package lesson004;

import java.util.Scanner;

public class Question32 {
	public static void main(String[] args) {
		//Girilen sayının mükemmel sayı olup olmadığına bakma
		//bölemlerin toplamı kendisini veren sayı
		//medium
		//hackerrank
		
		Scanner sc = new Scanner(System.in);
		int sayi , toplam=0;
		System.out.println("Lütfen Bir sayı giriniz");
		sayi = sc.nextInt();
		for(int i=1;i<=sayi/2;i++) {
			if(sayi%i==0) {
				toplam = toplam + i;
			}
		}
		if(toplam == sayi) {
			System.out.println(sayi +": Mükemmel Sayıdır");
		}
		else {
			System.out.println(sayi +": Mükemmel Sayı değildir");
		}
	}
}
